package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SubtitleDownloaderDialogBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final Button doneButton;

  @NonNull
  public final TextView movieName;

  @NonNull
  public final Button nextButton;

  @NonNull
  public final ViewPager pager;

  @NonNull
  public final TabLayout tabLayout;

  protected SubtitleDownloaderDialogBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout constraintLayout, Button doneButton,
      TextView movieName, Button nextButton, ViewPager pager, TabLayout tabLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.constraintLayout = constraintLayout;
    this.doneButton = doneButton;
    this.movieName = movieName;
    this.nextButton = nextButton;
    this.pager = pager;
    this.tabLayout = tabLayout;
  }

  @NonNull
  public static SubtitleDownloaderDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.subtitle_downloader_dialog, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SubtitleDownloaderDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SubtitleDownloaderDialogBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.subtitle_downloader_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static SubtitleDownloaderDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.subtitle_downloader_dialog, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SubtitleDownloaderDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SubtitleDownloaderDialogBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.subtitle_downloader_dialog, null, false, component);
  }

  public static SubtitleDownloaderDialogBinding bind(@NonNull View view) {
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
  public static SubtitleDownloaderDialogBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (SubtitleDownloaderDialogBinding)bind(component, view, org.videolan.vlc.R.layout.subtitle_downloader_dialog);
  }
}
