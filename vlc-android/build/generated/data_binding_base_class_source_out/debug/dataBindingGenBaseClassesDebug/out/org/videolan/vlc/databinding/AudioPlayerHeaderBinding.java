package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.audio.AudioPlayer;
import com.shera.internexttv.gui.view.HeaderMediaSwitcher;

public abstract class AudioPlayerHeaderBinding extends ViewDataBinding {
  @NonNull
  public final ImageView advFunction;

  @NonNull
  public final HeaderMediaSwitcher audioMediaSwitcher;

  @NonNull
  public final ConstraintLayout header;

  @NonNull
  public final ImageView headerPlayPause;

  @NonNull
  public final TextView headerTime;

  @NonNull
  public final ImageView playlistPlayasaudioOff;

  @NonNull
  public final ImageView playlistSearch;

  @NonNull
  public final TextInputLayout playlistSearchText;

  @NonNull
  public final ImageView playlistSwitch;

  @Bindable
  protected AudioPlayer mFragment;

  protected AudioPlayerHeaderBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView advFunction, HeaderMediaSwitcher audioMediaSwitcher, ConstraintLayout header,
      ImageView headerPlayPause, TextView headerTime, ImageView playlistPlayasaudioOff,
      ImageView playlistSearch, TextInputLayout playlistSearchText, ImageView playlistSwitch) {
    super(_bindingComponent, _root, _localFieldCount);
    this.advFunction = advFunction;
    this.audioMediaSwitcher = audioMediaSwitcher;
    this.header = header;
    this.headerPlayPause = headerPlayPause;
    this.headerTime = headerTime;
    this.playlistPlayasaudioOff = playlistPlayasaudioOff;
    this.playlistSearch = playlistSearch;
    this.playlistSearchText = playlistSearchText;
    this.playlistSwitch = playlistSwitch;
  }

  public abstract void setFragment(@Nullable AudioPlayer fragment);

  @Nullable
  public AudioPlayer getFragment() {
    return mFragment;
  }

  @NonNull
  public static AudioPlayerHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.audio_player_header, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AudioPlayerHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AudioPlayerHeaderBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.audio_player_header, root, attachToRoot, component);
  }

  @NonNull
  public static AudioPlayerHeaderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.audio_player_header, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AudioPlayerHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AudioPlayerHeaderBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.audio_player_header, null, false, component);
  }

  public static AudioPlayerHeaderBinding bind(@NonNull View view) {
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
  public static AudioPlayerHeaderBinding bind(@NonNull View view, @Nullable Object component) {
    return (AudioPlayerHeaderBinding)bind(component, view, org.videolan.vlc.R.layout.audio_player_header);
  }
}
