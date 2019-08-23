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
import org.videolan.medialibrary.media.DummyItem;

public abstract class AudioBrowserSeparatorBinding extends ViewDataBinding {
  @NonNull
  public final TextView title;

  @Bindable
  protected DummyItem mItem;

  protected AudioBrowserSeparatorBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.title = title;
  }

  public abstract void setItem(@Nullable DummyItem item);

  @Nullable
  public DummyItem getItem() {
    return mItem;
  }

  @NonNull
  public static AudioBrowserSeparatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.audio_browser_separator, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AudioBrowserSeparatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AudioBrowserSeparatorBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.audio_browser_separator, root, attachToRoot, component);
  }

  @NonNull
  public static AudioBrowserSeparatorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.audio_browser_separator, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AudioBrowserSeparatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AudioBrowserSeparatorBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.audio_browser_separator, null, false, component);
  }

  public static AudioBrowserSeparatorBinding bind(@NonNull View view) {
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
  public static AudioBrowserSeparatorBinding bind(@NonNull View view, @Nullable Object component) {
    return (AudioBrowserSeparatorBinding)bind(component, view, org.videolan.vlc.R.layout.audio_browser_separator);
  }
}
