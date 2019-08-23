package com.shera.internexttv.databinding;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.media.MediaLibraryItem;

public abstract class InfoActivityBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final RecyclerView ariane;

  @NonNull
  public final CollapsingToolbarLayout collapsingToolbar;

  @NonNull
  public final NestedScrollView container;

  @NonNull
  public final CoordinatorLayout coordinator;

  @NonNull
  public final ImageView extraIcon;

  @NonNull
  public final TextView extraTitle;

  @NonNull
  public final TextView extraValue;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final Guideline guideline10;

  @NonNull
  public final Guideline guideline9;

  @NonNull
  public final ProgressBar imageProgress;

  @NonNull
  public final ImageView infoSubtitles;

  @NonNull
  public final ImageView lengthIcon;

  @NonNull
  public final TextView lengthTitle;

  @NonNull
  public final TextView lengthValue;

  @NonNull
  public final RecyclerView list;

  @NonNull
  public final Toolbar mainToolbar;

  @NonNull
  public final TextView mlItemResolution;

  @NonNull
  public final ImageView playlistCover;

  @NonNull
  public final ImageView sizeIcon;

  @NonNull
  public final TextView sizeTitle;

  @NonNull
  public final TextView sizeValue;

  @Bindable
  protected MediaLibraryItem mItem;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected String mLength;

  @Bindable
  protected String mPath;

  @Bindable
  protected String mSizeTitleText;

  @Bindable
  protected String mExtraTitleText;

  @Bindable
  protected String mSizeValueText;

  @Bindable
  protected String mExtraValueText;

  @Bindable
  protected int mProgress;

  @Bindable
  protected String mResolution;

  protected InfoActivityBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppBarLayout appbar, RecyclerView ariane, CollapsingToolbarLayout collapsingToolbar,
      NestedScrollView container, CoordinatorLayout coordinator, ImageView extraIcon,
      TextView extraTitle, TextView extraValue, FloatingActionButton fab, Guideline guideline10,
      Guideline guideline9, ProgressBar imageProgress, ImageView infoSubtitles,
      ImageView lengthIcon, TextView lengthTitle, TextView lengthValue, RecyclerView list,
      Toolbar mainToolbar, TextView mlItemResolution, ImageView playlistCover, ImageView sizeIcon,
      TextView sizeTitle, TextView sizeValue) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbar = appbar;
    this.ariane = ariane;
    this.collapsingToolbar = collapsingToolbar;
    this.container = container;
    this.coordinator = coordinator;
    this.extraIcon = extraIcon;
    this.extraTitle = extraTitle;
    this.extraValue = extraValue;
    this.fab = fab;
    this.guideline10 = guideline10;
    this.guideline9 = guideline9;
    this.imageProgress = imageProgress;
    this.infoSubtitles = infoSubtitles;
    this.lengthIcon = lengthIcon;
    this.lengthTitle = lengthTitle;
    this.lengthValue = lengthValue;
    this.list = list;
    this.mainToolbar = mainToolbar;
    this.mlItemResolution = mlItemResolution;
    this.playlistCover = playlistCover;
    this.sizeIcon = sizeIcon;
    this.sizeTitle = sizeTitle;
    this.sizeValue = sizeValue;
  }

  public abstract void setItem(@Nullable MediaLibraryItem item);

  @Nullable
  public MediaLibraryItem getItem() {
    return mItem;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  public abstract void setLength(@Nullable String length);

  @Nullable
  public String getLength() {
    return mLength;
  }

  public abstract void setPath(@Nullable String path);

  @Nullable
  public String getPath() {
    return mPath;
  }

  public abstract void setSizeTitleText(@Nullable String sizeTitleText);

  @Nullable
  public String getSizeTitleText() {
    return mSizeTitleText;
  }

  public abstract void setExtraTitleText(@Nullable String extraTitleText);

  @Nullable
  public String getExtraTitleText() {
    return mExtraTitleText;
  }

  public abstract void setSizeValueText(@Nullable String sizeValueText);

  @Nullable
  public String getSizeValueText() {
    return mSizeValueText;
  }

  public abstract void setExtraValueText(@Nullable String extraValueText);

  @Nullable
  public String getExtraValueText() {
    return mExtraValueText;
  }

  public abstract void setProgress(int progress);

  public int getProgress() {
    return mProgress;
  }

  public abstract void setResolution(@Nullable String resolution);

  @Nullable
  public String getResolution() {
    return mResolution;
  }

  @NonNull
  public static InfoActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.info_activity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static InfoActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<InfoActivityBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.info_activity, root, attachToRoot, component);
  }

  @NonNull
  public static InfoActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.info_activity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static InfoActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<InfoActivityBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.info_activity, null, false, component);
  }

  public static InfoActivityBinding bind(@NonNull View view) {
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
  public static InfoActivityBinding bind(@NonNull View view, @Nullable Object component) {
    return (InfoActivityBinding)bind(component, view, org.videolan.vlc.R.layout.info_activity);
  }
}
