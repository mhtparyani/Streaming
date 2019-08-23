package com.shera.internexttv.databinding;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.media.MediaLibraryItem;
import com.shera.internexttv.gui.SimpleAdapter;

public abstract class SimpleItemBinding extends ViewDataBinding {
  @Bindable
  protected MediaLibraryItem mItem;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected SimpleAdapter.ClickHandler mHandler;

  protected SimpleItemBinding(Object _bindingComponent, View _root, int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setItem(@Nullable MediaLibraryItem item);

  @Nullable
  public MediaLibraryItem getItem() {
    return mItem;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  public abstract void setHandler(@Nullable SimpleAdapter.ClickHandler handler);

  @Nullable
  public SimpleAdapter.ClickHandler getHandler() {
    return mHandler;
  }

  @NonNull
  public static SimpleItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.simple_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SimpleItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SimpleItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.simple_item, root, attachToRoot, component);
  }

  @NonNull
  public static SimpleItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.simple_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SimpleItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SimpleItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.simple_item, null, false, component);
  }

  public static SimpleItemBinding bind(@NonNull View view) {
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
  public static SimpleItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (SimpleItemBinding)bind(component, view, org.videolan.vlc.R.layout.simple_item);
  }
}
