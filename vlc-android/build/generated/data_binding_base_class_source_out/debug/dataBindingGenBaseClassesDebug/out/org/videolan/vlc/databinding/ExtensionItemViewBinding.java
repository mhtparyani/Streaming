package com.shera.internexttv.databinding;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.extensions.api.VLCExtensionItem;
import com.shera.internexttv.gui.browser.ExtensionAdapter;

public abstract class ExtensionItemViewBinding extends ViewDataBinding {
  @NonNull
  public final TextView author;

  @NonNull
  public final ImageView extensionImage;

  @NonNull
  public final ImageView itemMore;

  @NonNull
  public final TextView title;

  @Bindable
  protected ExtensionAdapter.ViewHolder mHolder;

  @Bindable
  protected VLCExtensionItem mItem;

  @Bindable
  protected BitmapDrawable mCover;

  protected ExtensionItemViewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView author, ImageView extensionImage, ImageView itemMore, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.author = author;
    this.extensionImage = extensionImage;
    this.itemMore = itemMore;
    this.title = title;
  }

  public abstract void setHolder(@Nullable ExtensionAdapter.ViewHolder holder);

  @Nullable
  public ExtensionAdapter.ViewHolder getHolder() {
    return mHolder;
  }

  public abstract void setItem(@Nullable VLCExtensionItem item);

  @Nullable
  public VLCExtensionItem getItem() {
    return mItem;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  @NonNull
  public static ExtensionItemViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.extension_item_view, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ExtensionItemViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ExtensionItemViewBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.extension_item_view, root, attachToRoot, component);
  }

  @NonNull
  public static ExtensionItemViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.extension_item_view, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ExtensionItemViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ExtensionItemViewBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.extension_item_view, null, false, component);
  }

  public static ExtensionItemViewBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ExtensionItemViewBinding bind(@NonNull View view, @Nullable Object component) {
    return (ExtensionItemViewBinding)bind(component, view, org.videolan.vlc.R.layout.extension_item_view);
  }
}
