package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.libvlc.RendererItem;
import com.shera.internexttv.gui.dialogs.RenderersDialog;

public abstract class ItemRendererBinding extends ViewDataBinding {
  @NonNull
  public final TextView rendererName;

  @Bindable
  protected RendererItem mRenderer;

  @Bindable
  protected RenderersDialog.RendererClickhandler mClicHandler;

  protected ItemRendererBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView rendererName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rendererName = rendererName;
  }

  public abstract void setRenderer(@Nullable RendererItem renderer);

  @Nullable
  public RendererItem getRenderer() {
    return mRenderer;
  }

  public abstract void setClicHandler(@Nullable RenderersDialog.RendererClickhandler clicHandler);

  @Nullable
  public RenderersDialog.RendererClickhandler getClicHandler() {
    return mClicHandler;
  }

  @NonNull
  public static ItemRendererBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_renderer, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemRendererBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemRendererBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.item_renderer, root, attachToRoot, component);
  }

  @NonNull
  public static ItemRendererBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_renderer, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemRendererBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemRendererBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.item_renderer, null, false, component);
  }

  public static ItemRendererBinding bind(@NonNull View view) {
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
  public static ItemRendererBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemRendererBinding)bind(component, view, org.videolan.vlc.R.layout.item_renderer);
  }
}
