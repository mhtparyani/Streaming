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
import com.shera.internexttv.gui.SearchActivity;
import com.shera.internexttv.gui.SearchResultAdapter;

public abstract class SearchItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView itemDescription;

  @NonNull
  public final ImageView itemImage;

  @NonNull
  public final TextView itemTitle;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected MediaLibraryItem mItem;

  @Bindable
  protected SearchResultAdapter.ViewHolder mHolder;

  @Bindable
  protected SearchActivity.ClickHandler mHandler;

  @Bindable
  protected int mBgColor;

  protected SearchItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView itemDescription, ImageView itemImage, TextView itemTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemDescription = itemDescription;
    this.itemImage = itemImage;
    this.itemTitle = itemTitle;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  public abstract void setItem(@Nullable MediaLibraryItem item);

  @Nullable
  public MediaLibraryItem getItem() {
    return mItem;
  }

  public abstract void setHolder(@Nullable SearchResultAdapter.ViewHolder holder);

  @Nullable
  public SearchResultAdapter.ViewHolder getHolder() {
    return mHolder;
  }

  public abstract void setHandler(@Nullable SearchActivity.ClickHandler handler);

  @Nullable
  public SearchActivity.ClickHandler getHandler() {
    return mHandler;
  }

  public abstract void setBgColor(int bgColor);

  public int getBgColor() {
    return mBgColor;
  }

  @NonNull
  public static SearchItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.search_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SearchItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SearchItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.search_item, root, attachToRoot, component);
  }

  @NonNull
  public static SearchItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.search_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SearchItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SearchItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.search_item, null, false, component);
  }

  public static SearchItemBinding bind(@NonNull View view) {
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
  public static SearchItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (SearchItemBinding)bind(component, view, org.videolan.vlc.R.layout.search_item);
  }
}
