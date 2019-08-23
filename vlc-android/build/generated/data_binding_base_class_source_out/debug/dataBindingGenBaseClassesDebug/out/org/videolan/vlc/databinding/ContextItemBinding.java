package com.shera.internexttv.databinding;

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
import com.shera.internexttv.gui.dialogs.CtxOption;

public abstract class ContextItemBinding extends ViewDataBinding {
  @NonNull
  public final ImageView contextOptionIcon;

  @NonNull
  public final TextView contextOptionTitle;

  @Bindable
  protected CtxOption mOption;

  protected ContextItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView contextOptionIcon, TextView contextOptionTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.contextOptionIcon = contextOptionIcon;
    this.contextOptionTitle = contextOptionTitle;
  }

  public abstract void setOption(@Nullable CtxOption option);

  @Nullable
  public CtxOption getOption() {
    return mOption;
  }

  @NonNull
  public static ContextItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.context_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ContextItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ContextItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.context_item, root, attachToRoot, component);
  }

  @NonNull
  public static ContextItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.context_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ContextItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ContextItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.context_item, null, false, component);
  }

  public static ContextItemBinding bind(@NonNull View view) {
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
  public static ContextItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (ContextItemBinding)bind(component, view, org.videolan.vlc.R.layout.context_item);
  }
}
