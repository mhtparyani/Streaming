package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class PlayerHudRightBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout hudRightOverlay;

  @NonNull
  public final ImageView playerOverlayNavmenu;

  @NonNull
  public final TextView playerOverlayTitle;

  @NonNull
  public final ImageView playlistToggle;

  @NonNull
  public final ImageView videoRenderer;

  @NonNull
  public final ImageView videoSecondaryDisplay;

  protected PlayerHudRightBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout hudRightOverlay, ImageView playerOverlayNavmenu, TextView playerOverlayTitle,
      ImageView playlistToggle, ImageView videoRenderer, ImageView videoSecondaryDisplay) {
    super(_bindingComponent, _root, _localFieldCount);
    this.hudRightOverlay = hudRightOverlay;
    this.playerOverlayNavmenu = playerOverlayNavmenu;
    this.playerOverlayTitle = playerOverlayTitle;
    this.playlistToggle = playlistToggle;
    this.videoRenderer = videoRenderer;
    this.videoSecondaryDisplay = videoSecondaryDisplay;
  }

  @NonNull
  public static PlayerHudRightBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.player_hud_right, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PlayerHudRightBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PlayerHudRightBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.player_hud_right, root, attachToRoot, component);
  }

  @NonNull
  public static PlayerHudRightBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.player_hud_right, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PlayerHudRightBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PlayerHudRightBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.player_hud_right, null, false, component);
  }

  public static PlayerHudRightBinding bind(@NonNull View view) {
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
  public static PlayerHudRightBinding bind(@NonNull View view, @Nullable Object component) {
    return (PlayerHudRightBinding)bind(component, view, org.videolan.vlc.R.layout.player_hud_right);
  }
}
