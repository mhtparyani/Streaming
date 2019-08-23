package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.tv.FocusableRecyclerView;

public abstract class SongBrowserBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout content;

  @NonNull
  public final ImageButton headerButton;

  @NonNull
  public final TextView headerDescription;

  @NonNull
  public final RecyclerView headerList;

  @NonNull
  public final FrameLayout headerListContainer;

  @NonNull
  public final ImageButton imageButtonHeader;

  @NonNull
  public final ImageButton imageButtonSettings;

  @NonNull
  public final ImageButton imageButtonSort;

  @NonNull
  public final FocusableRecyclerView list;

  @NonNull
  public final ProgressBar loadingBar;

  @NonNull
  public final ImageButton sortButton;

  @NonNull
  public final TextView sortDescription;

  @NonNull
  public final TextView title;

  @NonNull
  public final Group toolbar;

  @Bindable
  protected boolean mLoading;

  protected SongBrowserBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout content, ImageButton headerButton, TextView headerDescription,
      RecyclerView headerList, FrameLayout headerListContainer, ImageButton imageButtonHeader,
      ImageButton imageButtonSettings, ImageButton imageButtonSort, FocusableRecyclerView list,
      ProgressBar loadingBar, ImageButton sortButton, TextView sortDescription, TextView title,
      Group toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    this.headerButton = headerButton;
    this.headerDescription = headerDescription;
    this.headerList = headerList;
    this.headerListContainer = headerListContainer;
    this.imageButtonHeader = imageButtonHeader;
    this.imageButtonSettings = imageButtonSettings;
    this.imageButtonSort = imageButtonSort;
    this.list = list;
    this.loadingBar = loadingBar;
    this.sortButton = sortButton;
    this.sortDescription = sortDescription;
    this.title = title;
    this.toolbar = toolbar;
  }

  public abstract void setLoading(boolean loading);

  public boolean getLoading() {
    return mLoading;
  }

  @NonNull
  public static SongBrowserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.song_browser, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SongBrowserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SongBrowserBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.song_browser, root, attachToRoot, component);
  }

  @NonNull
  public static SongBrowserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.song_browser, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SongBrowserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SongBrowserBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.song_browser, null, false, component);
  }

  public static SongBrowserBinding bind(@NonNull View view) {
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
  public static SongBrowserBinding bind(@NonNull View view, @Nullable Object component) {
    return (SongBrowserBinding)bind(component, view, org.videolan.vlc.R.layout.song_browser);
  }
}
