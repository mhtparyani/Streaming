package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SendCrashActivityBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout crashFirstStepContainer;

  @NonNull
  public final ConstraintLayout crashSecondStepContainer;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final Switch includeMedialibSwitch;

  @NonNull
  public final Button reportBugButton;

  @NonNull
  public final Button reportCrashButton;

  @NonNull
  public final Button sendCrashButton;

  @NonNull
  public final ProgressBar sendCrashProgress;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView18;

  @NonNull
  public final TextView textView19;

  @NonNull
  public final TextView textView21;

  protected SendCrashActivityBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout crashFirstStepContainer, ConstraintLayout crashSecondStepContainer,
      ImageView imageView5, Switch includeMedialibSwitch, Button reportBugButton,
      Button reportCrashButton, Button sendCrashButton, ProgressBar sendCrashProgress,
      TextView textView15, TextView textView18, TextView textView19, TextView textView21) {
    super(_bindingComponent, _root, _localFieldCount);
    this.crashFirstStepContainer = crashFirstStepContainer;
    this.crashSecondStepContainer = crashSecondStepContainer;
    this.imageView5 = imageView5;
    this.includeMedialibSwitch = includeMedialibSwitch;
    this.reportBugButton = reportBugButton;
    this.reportCrashButton = reportCrashButton;
    this.sendCrashButton = sendCrashButton;
    this.sendCrashProgress = sendCrashProgress;
    this.textView15 = textView15;
    this.textView18 = textView18;
    this.textView19 = textView19;
    this.textView21 = textView21;
  }

  @NonNull
  public static SendCrashActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.send_crash_activity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SendCrashActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SendCrashActivityBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.send_crash_activity, root, attachToRoot, component);
  }

  @NonNull
  public static SendCrashActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.send_crash_activity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SendCrashActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SendCrashActivityBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.send_crash_activity, null, false, component);
  }

  public static SendCrashActivityBinding bind(@NonNull View view) {
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
  public static SendCrashActivityBinding bind(@NonNull View view, @Nullable Object component) {
    return (SendCrashActivityBinding)bind(component, view, org.videolan.vlc.R.layout.send_crash_activity);
  }
}
