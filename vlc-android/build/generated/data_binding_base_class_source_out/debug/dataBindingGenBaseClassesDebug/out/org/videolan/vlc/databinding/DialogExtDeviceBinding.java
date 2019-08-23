package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.dialogs.ExtDeviceHandler;

public abstract class DialogExtDeviceBinding extends ViewDataBinding {
  @NonNull
  public final Button extDeviceCancel;

  @NonNull
  public final Button extDeviceOpen;

  @NonNull
  public final Button extDeviceScan;

  @NonNull
  public final TextView extDeviceSummary;

  @Bindable
  protected ExtDeviceHandler mHandler;

  protected DialogExtDeviceBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button extDeviceCancel, Button extDeviceOpen, Button extDeviceScan,
      TextView extDeviceSummary) {
    super(_bindingComponent, _root, _localFieldCount);
    this.extDeviceCancel = extDeviceCancel;
    this.extDeviceOpen = extDeviceOpen;
    this.extDeviceScan = extDeviceScan;
    this.extDeviceSummary = extDeviceSummary;
  }

  public abstract void setHandler(@Nullable ExtDeviceHandler handler);

  @Nullable
  public ExtDeviceHandler getHandler() {
    return mHandler;
  }

  @NonNull
  public static DialogExtDeviceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_ext_device, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogExtDeviceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogExtDeviceBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.dialog_ext_device, root, attachToRoot, component);
  }

  @NonNull
  public static DialogExtDeviceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_ext_device, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogExtDeviceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogExtDeviceBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.dialog_ext_device, null, false, component);
  }

  public static DialogExtDeviceBinding bind(@NonNull View view) {
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
  public static DialogExtDeviceBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogExtDeviceBinding)bind(component, view, org.videolan.vlc.R.layout.dialog_ext_device);
  }
}
