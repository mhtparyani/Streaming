package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class BrowserItemSeparatorBinding extends ViewDataBinding {
  @NonNull
  public final TextView separatorTitle;

  @Bindable
  protected String mTitle;

  protected BrowserItemSeparatorBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView separatorTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.separatorTitle = separatorTitle;
  }

  public abstract void setTitle(@Nullable String title);

  @Nullable
  public String getTitle() {
    return mTitle;
  }

  @NonNull
  public static BrowserItemSeparatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.browser_item_separator, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BrowserItemSeparatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BrowserItemSeparatorBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.browser_item_separator, root, attachToRoot, component);
  }

  @NonNull
  public static BrowserItemSeparatorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.browser_item_separator, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BrowserItemSeparatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BrowserItemSeparatorBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.browser_item_separator, null, false, component);
  }

  public static BrowserItemSeparatorBinding bind(@NonNull View view) {
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
  public static BrowserItemSeparatorBinding bind(@NonNull View view, @Nullable Object component) {
    return (BrowserItemSeparatorBinding)bind(component, view, org.videolan.vlc.R.layout.browser_item_separator);
  }
}
