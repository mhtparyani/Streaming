package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.view.FastScroller;
import com.shera.internexttv.gui.view.SwipeRefreshLayout;

public abstract class PlaylistsFragmentBinding extends ViewDataBinding {
  @NonNull
  public final TextView empty;

  @NonNull
  public final View playlistList;

  @NonNull
  public final FastScroller songsFastScroller;

  @NonNull
  public final SwipeRefreshLayout swipeLayout;

  protected PlaylistsFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView empty, View playlistList, FastScroller songsFastScroller,
      SwipeRefreshLayout swipeLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.empty = empty;
    this.playlistList = playlistList;
    this.songsFastScroller = songsFastScroller;
    this.swipeLayout = swipeLayout;
  }

  @NonNull
  public static PlaylistsFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.playlists_fragment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PlaylistsFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PlaylistsFragmentBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.playlists_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static PlaylistsFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.playlists_fragment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PlaylistsFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PlaylistsFragmentBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.playlists_fragment, null, false, component);
  }

  public static PlaylistsFragmentBinding bind(@NonNull View view) {
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
  public static PlaylistsFragmentBinding bind(@NonNull View view, @Nullable Object component) {
    return (PlaylistsFragmentBinding)bind(component, view, org.videolan.vlc.R.layout.playlists_fragment);
  }
}
