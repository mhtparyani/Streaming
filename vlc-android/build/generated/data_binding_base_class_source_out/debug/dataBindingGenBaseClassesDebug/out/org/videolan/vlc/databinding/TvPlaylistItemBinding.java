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
import org.videolan.medialibrary.interfaces.media.AbstractMediaWrapper;
import com.shera.internexttv.gui.view.MiniVisualizer;

public abstract class TvPlaylistItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView artist;

  @NonNull
  public final MiniVisualizer playing;

  @NonNull
  public final TextView title;

  @Bindable
  protected int mBgColor;

  @Bindable
  protected AbstractMediaWrapper mMedia;

  protected TvPlaylistItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView artist, MiniVisualizer playing, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.artist = artist;
    this.playing = playing;
    this.title = title;
  }

  public abstract void setBgColor(int bgColor);

  public int getBgColor() {
    return mBgColor;
  }

  public abstract void setMedia(@Nullable AbstractMediaWrapper media);

  @Nullable
  public AbstractMediaWrapper getMedia() {
    return mMedia;
  }

  @NonNull
  public static TvPlaylistItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.tv_playlist_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static TvPlaylistItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<TvPlaylistItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.tv_playlist_item, root, attachToRoot, component);
  }

  @NonNull
  public static TvPlaylistItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.tv_playlist_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static TvPlaylistItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<TvPlaylistItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.tv_playlist_item, null, false, component);
  }

  public static TvPlaylistItemBinding bind(@NonNull View view) {
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
  public static TvPlaylistItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (TvPlaylistItemBinding)bind(component, view, org.videolan.vlc.R.layout.tv_playlist_item);
  }
}
