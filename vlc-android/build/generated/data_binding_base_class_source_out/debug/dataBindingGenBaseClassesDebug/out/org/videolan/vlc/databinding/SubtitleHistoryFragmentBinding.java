package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SubtitleHistoryFragmentBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView subtitleList;

  protected SubtitleHistoryFragmentBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RecyclerView subtitleList) {
    super(_bindingComponent, _root, _localFieldCount);
    this.subtitleList = subtitleList;
  }

  @NonNull
  public static SubtitleHistoryFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.subtitle_history_fragment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SubtitleHistoryFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SubtitleHistoryFragmentBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.subtitle_history_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static SubtitleHistoryFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.subtitle_history_fragment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SubtitleHistoryFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SubtitleHistoryFragmentBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.subtitle_history_fragment, null, false, component);
  }

  public static SubtitleHistoryFragmentBinding bind(@NonNull View view) {
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
  public static SubtitleHistoryFragmentBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (SubtitleHistoryFragmentBinding)bind(component, view, org.videolan.vlc.R.layout.subtitle_history_fragment);
  }
}
