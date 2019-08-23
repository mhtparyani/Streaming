package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.libvlc.Dialog;
import com.shera.internexttv.gui.dialogs.VlcProgressDialog;

public abstract class VlcProgressDialogBinding extends ViewDataBinding {
  @NonNull
  public final Button cancel;

  @NonNull
  public final ContentLoadingProgressBar progress;

  @NonNull
  public final TextView text;

  @Bindable
  protected Dialog.ProgressDialog mDialog;

  @Bindable
  protected VlcProgressDialog mHandler;

  protected VlcProgressDialogBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button cancel, ContentLoadingProgressBar progress, TextView text) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cancel = cancel;
    this.progress = progress;
    this.text = text;
  }

  public abstract void setDialog(@Nullable Dialog.ProgressDialog dialog);

  @Nullable
  public Dialog.ProgressDialog getDialog() {
    return mDialog;
  }

  public abstract void setHandler(@Nullable VlcProgressDialog handler);

  @Nullable
  public VlcProgressDialog getHandler() {
    return mHandler;
  }

  @NonNull
  public static VlcProgressDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.vlc_progress_dialog, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static VlcProgressDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<VlcProgressDialogBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.vlc_progress_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static VlcProgressDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.vlc_progress_dialog, null, false, component)
   */
  @NonNull
  @Deprecated
  public static VlcProgressDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<VlcProgressDialogBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.vlc_progress_dialog, null, false, component);
  }

  public static VlcProgressDialogBinding bind(@NonNull View view) {
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
  public static VlcProgressDialogBinding bind(@NonNull View view, @Nullable Object component) {
    return (VlcProgressDialogBinding)bind(component, view, org.videolan.vlc.R.layout.vlc_progress_dialog);
  }
}
