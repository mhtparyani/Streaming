package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.libvlc.Dialog;
import com.shera.internexttv.gui.dialogs.VlcLoginDialog;

public abstract class VlcLoginDialogBinding extends ViewDataBinding {
  @NonNull
  public final Button action;

  @NonNull
  public final Button cancel;

  @NonNull
  public final EditText login;

  @NonNull
  public final TextInputLayout loginContainer;

  @NonNull
  public final EditText password;

  @NonNull
  public final TextInputLayout passwordContainer;

  @NonNull
  public final CheckBox store;

  @NonNull
  public final TextView text;

  @NonNull
  public final TextView warning;

  @Bindable
  protected Dialog.LoginDialog mDialog;

  @Bindable
  protected VlcLoginDialog mHandler;

  protected VlcLoginDialogBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button action, Button cancel, EditText login, TextInputLayout loginContainer,
      EditText password, TextInputLayout passwordContainer, CheckBox store, TextView text,
      TextView warning) {
    super(_bindingComponent, _root, _localFieldCount);
    this.action = action;
    this.cancel = cancel;
    this.login = login;
    this.loginContainer = loginContainer;
    this.password = password;
    this.passwordContainer = passwordContainer;
    this.store = store;
    this.text = text;
    this.warning = warning;
  }

  public abstract void setDialog(@Nullable Dialog.LoginDialog dialog);

  @Nullable
  public Dialog.LoginDialog getDialog() {
    return mDialog;
  }

  public abstract void setHandler(@Nullable VlcLoginDialog handler);

  @Nullable
  public VlcLoginDialog getHandler() {
    return mHandler;
  }

  @NonNull
  public static VlcLoginDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.vlc_login_dialog, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static VlcLoginDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<VlcLoginDialogBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.vlc_login_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static VlcLoginDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.vlc_login_dialog, null, false, component)
   */
  @NonNull
  @Deprecated
  public static VlcLoginDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<VlcLoginDialogBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.vlc_login_dialog, null, false, component);
  }

  public static VlcLoginDialogBinding bind(@NonNull View view) {
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
  public static VlcLoginDialogBinding bind(@NonNull View view, @Nullable Object component) {
    return (VlcLoginDialogBinding)bind(component, view, org.videolan.vlc.R.layout.vlc_login_dialog);
  }
}
