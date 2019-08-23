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
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.view.SwipeRefreshLayout;

public abstract class DirectoryBrowserBinding extends ViewDataBinding {
  @NonNull
  public final TextView empty;

  @NonNull
  public final RecyclerView networkList;

  @NonNull
  public final SwipeRefreshLayout swipeLayout;

  @Bindable
  protected boolean mShowFavorites;

  protected DirectoryBrowserBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView empty, RecyclerView networkList, SwipeRefreshLayout swipeLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.empty = empty;
    this.networkList = networkList;
    this.swipeLayout = swipeLayout;
  }

  public abstract void setShowFavorites(boolean showFavorites);

  public boolean getShowFavorites() {
    return mShowFavorites;
  }

  @NonNull
  public static DirectoryBrowserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.directory_browser, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DirectoryBrowserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DirectoryBrowserBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.directory_browser, root, attachToRoot, component);
  }

  @NonNull
  public static DirectoryBrowserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.directory_browser, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DirectoryBrowserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DirectoryBrowserBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.directory_browser, null, false, component);
  }

  public static DirectoryBrowserBinding bind(@NonNull View view) {
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
  public static DirectoryBrowserBinding bind(@NonNull View view, @Nullable Object component) {
    return (DirectoryBrowserBinding)bind(component, view, org.videolan.vlc.R.layout.directory_browser);
  }
}
