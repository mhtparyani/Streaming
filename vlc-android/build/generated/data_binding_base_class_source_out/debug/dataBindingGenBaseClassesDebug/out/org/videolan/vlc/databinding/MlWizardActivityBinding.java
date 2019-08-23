package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class MlWizardActivityBinding extends ViewDataBinding {
  @NonNull
  public final Switch wizardCheckScan;

  @NonNull
  public final TextView wizardDescription;

  @NonNull
  public final Button wizardValidate;

  protected MlWizardActivityBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Switch wizardCheckScan, TextView wizardDescription, Button wizardValidate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.wizardCheckScan = wizardCheckScan;
    this.wizardDescription = wizardDescription;
    this.wizardValidate = wizardValidate;
  }

  @NonNull
  public static MlWizardActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.ml_wizard_activity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static MlWizardActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<MlWizardActivityBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.ml_wizard_activity, root, attachToRoot, component);
  }

  @NonNull
  public static MlWizardActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.ml_wizard_activity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static MlWizardActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<MlWizardActivityBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.ml_wizard_activity, null, false, component);
  }

  public static MlWizardActivityBinding bind(@NonNull View view) {
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
  public static MlWizardActivityBinding bind(@NonNull View view, @Nullable Object component) {
    return (MlWizardActivityBinding)bind(component, view, org.videolan.vlc.R.layout.ml_wizard_activity);
  }
}
