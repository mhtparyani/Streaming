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
import org.videolan.libvlc.Dialog;
import com.shera.internexttv.gui.dialogs.VlcQuestionDialog;

public abstract class VlcQuestionDialogBinding extends ViewDataBinding {
  @NonNull
  public final Button action1;

  @NonNull
  public final Button action2;

  @NonNull
  public final Button cancel;

  @NonNull
  public final TextView text;

  @Bindable
  protected Dialog.QuestionDialog mDialog;

  @Bindable
  protected VlcQuestionDialog mHandler;

  protected VlcQuestionDialogBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button action1, Button action2, Button cancel, TextView text) {
    super(_bindingComponent, _root, _localFieldCount);
    this.action1 = action1;
    this.action2 = action2;
    this.cancel = cancel;
    this.text = text;
  }

  public abstract void setDialog(@Nullable Dialog.QuestionDialog dialog);

  @Nullable
  public Dialog.QuestionDialog getDialog() {
    return mDialog;
  }

  public abstract void setHandler(@Nullable VlcQuestionDialog handler);

  @Nullable
  public VlcQuestionDialog getHandler() {
    return mHandler;
  }

  @NonNull
  public static VlcQuestionDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.vlc_question_dialog, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static VlcQuestionDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<VlcQuestionDialogBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.vlc_question_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static VlcQuestionDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.vlc_question_dialog, null, false, component)
   */
  @NonNull
  @Deprecated
  public static VlcQuestionDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<VlcQuestionDialogBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.vlc_question_dialog, null, false, component);
  }

  public static VlcQuestionDialogBinding bind(@NonNull View view) {
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
  public static VlcQuestionDialogBinding bind(@NonNull View view, @Nullable Object component) {
    return (VlcQuestionDialogBinding)bind(component, view, org.videolan.vlc.R.layout.vlc_question_dialog);
  }
}
