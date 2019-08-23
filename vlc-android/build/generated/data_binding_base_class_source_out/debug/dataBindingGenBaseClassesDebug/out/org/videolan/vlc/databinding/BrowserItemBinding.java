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
import org.videolan.medialibrary.media.MediaLibraryItem;
import com.shera.internexttv.gui.browser.BaseBrowserAdapter;
import com.shera.internexttv.gui.helpers.ThreeStatesCheckbox;

public abstract class BrowserItemBinding extends ViewDataBinding {
  @NonNull
  public final ThreeStatesCheckbox browserCheckbox;

  @NonNull
  public final TextView dviIcon;

  @NonNull
  public final ImageView itemIcon;

  @NonNull
  public final ImageView itemMore;

  @NonNull
  public final TextView text;

  @NonNull
  public final TextView title;

  @Bindable
  protected BaseBrowserAdapter.ViewHolder mHolder;

  @Bindable
  protected MediaLibraryItem mItem;

  @Bindable
  protected String mFilename;

  @Bindable
  protected boolean mHasContextMenu;

  @Bindable
  protected boolean mCheckEnabled;

  @Bindable
  protected String mProtocol;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected int mBgColor;

  protected BrowserItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ThreeStatesCheckbox browserCheckbox, TextView dviIcon, ImageView itemIcon, ImageView itemMore,
      TextView text, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.browserCheckbox = browserCheckbox;
    this.dviIcon = dviIcon;
    this.itemIcon = itemIcon;
    this.itemMore = itemMore;
    this.text = text;
    this.title = title;
  }

  public abstract void setHolder(@Nullable BaseBrowserAdapter.ViewHolder holder);

  @Nullable
  public BaseBrowserAdapter.ViewHolder getHolder() {
    return mHolder;
  }

  public abstract void setItem(@Nullable MediaLibraryItem item);

  @Nullable
  public MediaLibraryItem getItem() {
    return mItem;
  }

  public abstract void setFilename(@Nullable String filename);

  @Nullable
  public String getFilename() {
    return mFilename;
  }

  public abstract void setHasContextMenu(boolean hasContextMenu);

  public boolean getHasContextMenu() {
    return mHasContextMenu;
  }

  public abstract void setCheckEnabled(boolean checkEnabled);

  public boolean getCheckEnabled() {
    return mCheckEnabled;
  }

  public abstract void setProtocol(@Nullable String protocol);

  @Nullable
  public String getProtocol() {
    return mProtocol;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  public abstract void setBgColor(int bgColor);

  public int getBgColor() {
    return mBgColor;
  }

  @NonNull
  public static BrowserItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.browser_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BrowserItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BrowserItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.browser_item, root, attachToRoot, component);
  }

  @NonNull
  public static BrowserItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.browser_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BrowserItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BrowserItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.browser_item, null, false, component);
  }

  public static BrowserItemBinding bind(@NonNull View view) {
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
  public static BrowserItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (BrowserItemBinding)bind(component, view, org.videolan.vlc.R.layout.browser_item);
  }
}
