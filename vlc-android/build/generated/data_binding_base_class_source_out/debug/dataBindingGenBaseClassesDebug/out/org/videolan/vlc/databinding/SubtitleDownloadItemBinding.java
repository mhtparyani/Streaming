package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.dialogs.SubtitleItem;

public abstract class SubtitleDownloadItemBinding extends ViewDataBinding {
  @NonNull
  public final Barrier barrier;

  @NonNull
  public final ImageView downloadSub;

  @NonNull
  public final TextView language;

  @NonNull
  public final ProgressBar loading;

  @NonNull
  public final TextView subTitle;

  @Bindable
  protected SubtitleItem mSubtitleItem;

  protected SubtitleDownloadItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Barrier barrier, ImageView downloadSub, TextView language, ProgressBar loading,
      TextView subTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.barrier = barrier;
    this.downloadSub = downloadSub;
    this.language = language;
    this.loading = loading;
    this.subTitle = subTitle;
  }

  public abstract void setSubtitleItem(@Nullable SubtitleItem subtitleItem);

  @Nullable
  public SubtitleItem getSubtitleItem() {
    return mSubtitleItem;
  }

  @NonNull
  public static SubtitleDownloadItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.subtitle_download_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SubtitleDownloadItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SubtitleDownloadItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.subtitle_download_item, root, attachToRoot, component);
  }

  @NonNull
  public static SubtitleDownloadItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.subtitle_download_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SubtitleDownloadItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SubtitleDownloadItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.subtitle_download_item, null, false, component);
  }

  public static SubtitleDownloadItemBinding bind(@NonNull View view) {
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
  public static SubtitleDownloadItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (SubtitleDownloadItemBinding)bind(component, view, org.videolan.vlc.R.layout.subtitle_download_item);
  }
}
