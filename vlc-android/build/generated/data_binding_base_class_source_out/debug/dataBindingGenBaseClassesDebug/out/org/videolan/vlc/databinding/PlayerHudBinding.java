package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.video.VideoPlayerActivity;
import com.shera.internexttv.media.Progress;

public abstract class PlayerHudBinding extends ViewDataBinding {
  @NonNull
  public final ImageView lockOverlayButton;

  @NonNull
  public final ImageView orientationToggle;

  @NonNull
  public final ImageView playerOverlayAdvFunction;

  @NonNull
  public final ImageView playerOverlayForward;

  @NonNull
  public final TextView playerOverlayLength;

  @NonNull
  public final FrameLayout playerOverlayLengthContainer;

  @NonNull
  public final ImageView playerOverlayPlay;

  @NonNull
  public final ImageView playerOverlayRewind;

  @NonNull
  public final SeekBar playerOverlaySeekbar;

  @NonNull
  public final TextView playerOverlayTime;

  @NonNull
  public final FrameLayout playerOverlayTimeContainer;

  @NonNull
  public final ImageView playerOverlayTracks;

  @NonNull
  public final ImageView playlistNext;

  @NonNull
  public final ImageView playlistPrevious;

  @NonNull
  public final ConstraintLayout progressOverlay;

  @Bindable
  protected LiveData<Progress> mProgress;

  @Bindable
  protected VideoPlayerActivity mPlayer;

  protected PlayerHudBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView lockOverlayButton, ImageView orientationToggle, ImageView playerOverlayAdvFunction,
      ImageView playerOverlayForward, TextView playerOverlayLength,
      FrameLayout playerOverlayLengthContainer, ImageView playerOverlayPlay,
      ImageView playerOverlayRewind, SeekBar playerOverlaySeekbar, TextView playerOverlayTime,
      FrameLayout playerOverlayTimeContainer, ImageView playerOverlayTracks, ImageView playlistNext,
      ImageView playlistPrevious, ConstraintLayout progressOverlay) {
    super(_bindingComponent, _root, _localFieldCount);
    this.lockOverlayButton = lockOverlayButton;
    this.orientationToggle = orientationToggle;
    this.playerOverlayAdvFunction = playerOverlayAdvFunction;
    this.playerOverlayForward = playerOverlayForward;
    this.playerOverlayLength = playerOverlayLength;
    this.playerOverlayLengthContainer = playerOverlayLengthContainer;
    this.playerOverlayPlay = playerOverlayPlay;
    this.playerOverlayRewind = playerOverlayRewind;
    this.playerOverlaySeekbar = playerOverlaySeekbar;
    this.playerOverlayTime = playerOverlayTime;
    this.playerOverlayTimeContainer = playerOverlayTimeContainer;
    this.playerOverlayTracks = playerOverlayTracks;
    this.playlistNext = playlistNext;
    this.playlistPrevious = playlistPrevious;
    this.progressOverlay = progressOverlay;
  }

  public abstract void setProgress(@Nullable LiveData<Progress> progress);

  @Nullable
  public LiveData<Progress> getProgress() {
    return mProgress;
  }

  public abstract void setPlayer(@Nullable VideoPlayerActivity player);

  @Nullable
  public VideoPlayerActivity getPlayer() {
    return mPlayer;
  }

  @NonNull
  public static PlayerHudBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.player_hud, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PlayerHudBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PlayerHudBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.player_hud, root, attachToRoot, component);
  }

  @NonNull
  public static PlayerHudBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.player_hud, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PlayerHudBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PlayerHudBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.player_hud, null, false, component);
  }

  public static PlayerHudBinding bind(@NonNull View view) {
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
  public static PlayerHudBinding bind(@NonNull View view, @Nullable Object component) {
    return (PlayerHudBinding)bind(component, view, org.videolan.vlc.R.layout.player_hud);
  }
}
