package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class MrlItemBinding extends ViewDataBinding {
  @NonNull
  public final ImageView mrlCtx;

  @NonNull
  public final TextView mrlItemTitle;

  @NonNull
  public final TextView mrlItemUri;

  protected MrlItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView mrlCtx, TextView mrlItemTitle, TextView mrlItemUri) {
    super(_bindingComponent, _root, _localFieldCount);
    this.mrlCtx = mrlCtx;
    this.mrlItemTitle = mrlItemTitle;
    this.mrlItemUri = mrlItemUri;
  }

  @NonNull
  public static MrlItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.mrl_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static MrlItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<MrlItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.mrl_item, root, attachToRoot, component);
  }

  @NonNull
  public static MrlItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.mrl_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static MrlItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<MrlItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.mrl_item, null, false, component);
  }

  public static MrlItemBinding bind(@NonNull View view) {
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
  public static MrlItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (MrlItemBinding)bind(component, view, org.videolan.vlc.R.layout.mrl_item);
  }
}
