package com.shera.internexttv.databinding;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.interfaces.media.AbstractMediaWrapper;
import com.shera.internexttv.gui.audio.PlaylistAdapter;
import com.shera.internexttv.gui.view.MiniVisualizer;

public abstract class PlaylistItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView audioItemSubtitle;

  @NonNull
  public final TextView audioItemTitle;

  @NonNull
  public final ImageView coverImage;

  @NonNull
  public final ImageButton itemMore;

  @NonNull
  public final MiniVisualizer playing;

  @NonNull
  public final View selector;

  @Bindable
  protected PlaylistAdapter.ViewHolder mHolder;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected AbstractMediaWrapper mMedia;

  @Bindable
  protected String mSubTitle;

  protected PlaylistItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView audioItemSubtitle, TextView audioItemTitle, ImageView coverImage,
      ImageButton itemMore, MiniVisualizer playing, View selector) {
    super(_bindingComponent, _root, _localFieldCount);
    this.audioItemSubtitle = audioItemSubtitle;
    this.audioItemTitle = audioItemTitle;
    this.coverImage = coverImage;
    this.itemMore = itemMore;
    this.playing = playing;
    this.selector = selector;
  }

  public abstract void setHolder(@Nullable PlaylistAdapter.ViewHolder holder);

  @Nullable
  public PlaylistAdapter.ViewHolder getHolder() {
    return mHolder;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  public abstract void setMedia(@Nullable AbstractMediaWrapper media);

  @Nullable
  public AbstractMediaWrapper getMedia() {
    return mMedia;
  }

  public abstract void setSubTitle(@Nullable String subTitle);

  @Nullable
  public String getSubTitle() {
    return mSubTitle;
  }

  @NonNull
  public static PlaylistItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.playlist_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PlaylistItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PlaylistItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.playlist_item, root, attachToRoot, component);
  }

  @NonNull
  public static PlaylistItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.playlist_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PlaylistItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PlaylistItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.playlist_item, null, false, component);
  }

  public static PlaylistItemBinding bind(@NonNull View view) {
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
  public static PlaylistItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (PlaylistItemBinding)bind(component, view, org.videolan.vlc.R.layout.playlist_item);
  }
}
