package com.shera.internexttv.databinding;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.media.MediaLibraryItem;

public abstract class PlaylistActivityBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final CollapsingToolbarLayout collapsingToolbar;

  @NonNull
  public final CoordinatorLayout coordinator;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final Toolbar mainToolbar;

  @NonNull
  public final ImageView playlistCover;

  @NonNull
  public final RecyclerView songs;

  @Bindable
  protected MediaLibraryItem mPlaylist;

  @Bindable
  protected BitmapDrawable mCover;

  protected PlaylistActivityBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppBarLayout appbar, CollapsingToolbarLayout collapsingToolbar, CoordinatorLayout coordinator,
      FloatingActionButton fab, Toolbar mainToolbar, ImageView playlistCover, RecyclerView songs) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbar = appbar;
    this.collapsingToolbar = collapsingToolbar;
    this.coordinator = coordinator;
    this.fab = fab;
    this.mainToolbar = mainToolbar;
    this.playlistCover = playlistCover;
    this.songs = songs;
  }

  public abstract void setPlaylist(@Nullable MediaLibraryItem playlist);

  @Nullable
  public MediaLibraryItem getPlaylist() {
    return mPlaylist;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  @NonNull
  public static PlaylistActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.playlist_activity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PlaylistActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PlaylistActivityBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.playlist_activity, root, attachToRoot, component);
  }

  @NonNull
  public static PlaylistActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.playlist_activity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PlaylistActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PlaylistActivityBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.playlist_activity, null, false, component);
  }

  public static PlaylistActivityBinding bind(@NonNull View view) {
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
  public static PlaylistActivityBinding bind(@NonNull View view, @Nullable Object component) {
    return (PlaylistActivityBinding)bind(component, view, org.videolan.vlc.R.layout.playlist_activity);
  }
}
