package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.viewmodels.StreamsModel;

public abstract class MrlPanelBinding extends ViewDataBinding {
  @NonNull
  public final TextInputLayout mrlEdit;

  @NonNull
  public final RecyclerView mrlList;

  @NonNull
  public final ConstraintLayout mrlRoot;

  @NonNull
  public final ConstraintLayout mrlbar;

  @NonNull
  public final ImageView play;

  @Bindable
  protected StreamsModel mViewmodel;

  protected MrlPanelBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextInputLayout mrlEdit, RecyclerView mrlList, ConstraintLayout mrlRoot,
      ConstraintLayout mrlbar, ImageView play) {
    super(_bindingComponent, _root, _localFieldCount);
    this.mrlEdit = mrlEdit;
    this.mrlList = mrlList;
    this.mrlRoot = mrlRoot;
    this.mrlbar = mrlbar;
    this.play = play;
  }

  public abstract void setViewmodel(@Nullable StreamsModel viewmodel);

  @Nullable
  public StreamsModel getViewmodel() {
    return mViewmodel;
  }

  @NonNull
  public static MrlPanelBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.mrl_panel, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static MrlPanelBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<MrlPanelBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.mrl_panel, root, attachToRoot, component);
  }

  @NonNull
  public static MrlPanelBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.mrl_panel, null, false, component)
   */
  @NonNull
  @Deprecated
  public static MrlPanelBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<MrlPanelBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.mrl_panel, null, false, component);
  }

  public static MrlPanelBinding bind(@NonNull View view) {
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
  public static MrlPanelBinding bind(@NonNull View view, @Nullable Object component) {
    return (MrlPanelBinding)bind(component, view, org.videolan.vlc.R.layout.mrl_panel);
  }
}
