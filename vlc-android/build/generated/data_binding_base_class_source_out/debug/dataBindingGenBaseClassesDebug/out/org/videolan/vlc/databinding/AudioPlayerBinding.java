package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.audio.AudioPlayer;
import com.shera.internexttv.gui.view.CoverMediaSwitcher;
import com.shera.internexttv.gui.view.HeaderMediaSwitcher;

public abstract class AudioPlayerBinding extends ViewDataBinding {
  @NonNull
  public final ImageView advFunction;

  @NonNull
  public final HeaderMediaSwitcher audioMediaSwitcher;

  @NonNull
  public final ImageView backgroundView;

  @NonNull
  public final Barrier barrier;

  @Nullable
  public final View bottomBar;

  @NonNull
  public final ConstraintLayout contentLayout;

  @NonNull
  public final CoverMediaSwitcher coverMediaSwitcher;

  @NonNull
  public final ConstraintLayout header;

  @NonNull
  public final ImageView headerPlayPause;

  @NonNull
  public final TextView headerTime;

  @NonNull
  public final TextView length;

  @NonNull
  public final ImageView next;

  @NonNull
  public final ImageView playPause;

  @NonNull
  public final ViewStubCompat playerOptionsStub;

  @NonNull
  public final ImageView playlistPlayasaudioOff;

  @NonNull
  public final ImageView playlistSearch;

  @NonNull
  public final TextInputLayout playlistSearchText;

  @NonNull
  public final ImageView playlistSwitch;

  @NonNull
  public final ImageView previous;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final ImageView repeat;

  @NonNull
  public final ImageView shuffle;

  @NonNull
  public final RecyclerView songsList;

  @NonNull
  public final TextView time;

  @NonNull
  public final SeekBar timeline;

  @Bindable
  protected AudioPlayer mFragment;

  @Bindable
  protected boolean mShowCover;

  protected AudioPlayerBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView advFunction, HeaderMediaSwitcher audioMediaSwitcher, ImageView backgroundView,
      Barrier barrier, View bottomBar, ConstraintLayout contentLayout,
      CoverMediaSwitcher coverMediaSwitcher, ConstraintLayout header, ImageView headerPlayPause,
      TextView headerTime, TextView length, ImageView next, ImageView playPause,
      ViewStubCompat playerOptionsStub, ImageView playlistPlayasaudioOff, ImageView playlistSearch,
      TextInputLayout playlistSearchText, ImageView playlistSwitch, ImageView previous,
      ProgressBar progressBar, ImageView repeat, ImageView shuffle, RecyclerView songsList,
      TextView time, SeekBar timeline) {
    super(_bindingComponent, _root, _localFieldCount);
    this.advFunction = advFunction;
    this.audioMediaSwitcher = audioMediaSwitcher;
    this.backgroundView = backgroundView;
    this.barrier = barrier;
    this.bottomBar = bottomBar;
    this.contentLayout = contentLayout;
    this.coverMediaSwitcher = coverMediaSwitcher;
    this.header = header;
    this.headerPlayPause = headerPlayPause;
    this.headerTime = headerTime;
    this.length = length;
    this.next = next;
    this.playPause = playPause;
    this.playerOptionsStub = playerOptionsStub;
    this.playlistPlayasaudioOff = playlistPlayasaudioOff;
    this.playlistSearch = playlistSearch;
    this.playlistSearchText = playlistSearchText;
    this.playlistSwitch = playlistSwitch;
    this.previous = previous;
    this.progressBar = progressBar;
    this.repeat = repeat;
    this.shuffle = shuffle;
    this.songsList = songsList;
    this.time = time;
    this.timeline = timeline;
  }

  public abstract void setFragment(@Nullable AudioPlayer fragment);

  @Nullable
  public AudioPlayer getFragment() {
    return mFragment;
  }

  public abstract void setShowCover(boolean showCover);

  public boolean getShowCover() {
    return mShowCover;
  }

  @NonNull
  public static AudioPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.audio_player, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AudioPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AudioPlayerBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.audio_player, root, attachToRoot, component);
  }

  @NonNull
  public static AudioPlayerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.audio_player, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AudioPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AudioPlayerBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.audio_player, null, false, component);
  }

  public static AudioPlayerBinding bind(@NonNull View view) {
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
  public static AudioPlayerBinding bind(@NonNull View view, @Nullable Object component) {
    return (AudioPlayerBinding)bind(component, view, org.videolan.vlc.R.layout.audio_player);
  }
}
