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
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.dialogs.RenderersDialog;

public abstract class DialogRenderersBinding extends ViewDataBinding {
  @NonNull
  public final Button renderersDisconnect;

  @NonNull
  public final RecyclerView renderersList;

  @NonNull
  public final TextView renderersTitle;

  @Bindable
  protected RenderersDialog.RendererClickhandler mHolder;

  protected DialogRenderersBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button renderersDisconnect, RecyclerView renderersList, TextView renderersTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.renderersDisconnect = renderersDisconnect;
    this.renderersList = renderersList;
    this.renderersTitle = renderersTitle;
  }

  public abstract void setHolder(@Nullable RenderersDialog.RendererClickhandler holder);

  @Nullable
  public RenderersDialog.RendererClickhandler getHolder() {
    return mHolder;
  }

  @NonNull
  public static DialogRenderersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_renderers, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogRenderersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogRenderersBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.dialog_renderers, root, attachToRoot, component);
  }

  @NonNull
  public static DialogRenderersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_renderers, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogRenderersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogRenderersBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.dialog_renderers, null, false, component);
  }

  public static DialogRenderersBinding bind(@NonNull View view) {
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
  public static DialogRenderersBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogRenderersBinding)bind(component, view, org.videolan.vlc.R.layout.dialog_renderers);
  }
}
