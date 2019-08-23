package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.viewmodels.PlaybackProgress;

public abstract class TvAudioPlayerBinding extends ViewDataBinding {
  @NonNull
  public final ImageView albumCover;

  @NonNull
  public final ImageView background;

  @NonNull
  public final AppCompatImageView buttonNext;

  @NonNull
  public final AppCompatImageView buttonPlay;

  @NonNull
  public final AppCompatImageView buttonPrevious;

  @NonNull
  public final AppCompatImageView buttonRepeat;

  @NonNull
  public final AppCompatImageView buttonShuffle;

  @NonNull
  public final TextView mediaArtist;

  @NonNull
  public final TextView mediaLength;

  @NonNull
  public final ProgressBar mediaProgress;

  @NonNull
  public final TextView mediaTime;

  @NonNull
  public final TextView mediaTitle;

  @NonNull
  public final RecyclerView playlist;

  @Bindable
  protected LiveData<PlaybackProgress> mProgress;

  protected TvAudioPlayerBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView albumCover, ImageView background, AppCompatImageView buttonNext,
      AppCompatImageView buttonPlay, AppCompatImageView buttonPrevious,
      AppCompatImageView buttonRepeat, AppCompatImageView buttonShuffle, TextView mediaArtist,
      TextView mediaLength, ProgressBar mediaProgress, TextView mediaTime, TextView mediaTitle,
      RecyclerView playlist) {
    super(_bindingComponent, _root, _localFieldCount);
    this.albumCover = albumCover;
    this.background = background;
    this.buttonNext = buttonNext;
    this.buttonPlay = buttonPlay;
    this.buttonPrevious = buttonPrevious;
    this.buttonRepeat = buttonRepeat;
    this.buttonShuffle = buttonShuffle;
    this.mediaArtist = mediaArtist;
    this.mediaLength = mediaLength;
    this.mediaProgress = mediaProgress;
    this.mediaTime = mediaTime;
    this.mediaTitle = mediaTitle;
    this.playlist = playlist;
  }

  public abstract void setProgress(@Nullable LiveData<PlaybackProgress> progress);

  @Nullable
  public LiveData<PlaybackProgress> getProgress() {
    return mProgress;
  }

  @NonNull
  public static TvAudioPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.tv_audio_player, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static TvAudioPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<TvAudioPlayerBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.tv_audio_player, root, attachToRoot, component);
  }

  @NonNull
  public static TvAudioPlayerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.tv_audio_player, null, false, component)
   */
  @NonNull
  @Deprecated
  public static TvAudioPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<TvAudioPlayerBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.tv_audio_player, null, false, component);
  }

  public static TvAudioPlayerBinding bind(@NonNull View view) {
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
  public static TvAudioPlayerBinding bind(@NonNull View view, @Nullable Object component) {
    return (TvAudioPlayerBinding)bind(component, view, org.videolan.vlc.R.layout.tv_audio_player);
  }
}
