package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityBetaWelcomeBinding extends ViewDataBinding {
  @NonNull
  public final Button betaOkButton;

  @NonNull
  public final ImageView imageView6;

  @NonNull
  public final ImageView imageView7;

  @NonNull
  public final TextView textView20;

  @NonNull
  public final TextView textView23;

  @NonNull
  public final TextView textView24;

  @NonNull
  public final TextView textView25;

  protected ActivityBetaWelcomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button betaOkButton, ImageView imageView6, ImageView imageView7, TextView textView20,
      TextView textView23, TextView textView24, TextView textView25) {
    super(_bindingComponent, _root, _localFieldCount);
    this.betaOkButton = betaOkButton;
    this.imageView6 = imageView6;
    this.imageView7 = imageView7;
    this.textView20 = textView20;
    this.textView23 = textView23;
    this.textView24 = textView24;
    this.textView25 = textView25;
  }

  @NonNull
  public static ActivityBetaWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_beta_welcome, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityBetaWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityBetaWelcomeBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.activity_beta_welcome, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityBetaWelcomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_beta_welcome, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityBetaWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityBetaWelcomeBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.activity_beta_welcome, null, false, component);
  }

  public static ActivityBetaWelcomeBinding bind(@NonNull View view) {
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
  public static ActivityBetaWelcomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityBetaWelcomeBinding)bind(component, view, org.videolan.vlc.R.layout.activity_beta_welcome);
  }
}
