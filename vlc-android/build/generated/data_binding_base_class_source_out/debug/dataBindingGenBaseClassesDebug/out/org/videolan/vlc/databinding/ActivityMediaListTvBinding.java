package com.shera.internexttv.databinding;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.media.MediaLibraryItem;
import com.shera.internexttv.gui.tv.FocusableRecyclerView;

public abstract class ActivityMediaListTvBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageButton addPlaylist;

  @NonNull
  public final TextView albumSubtitle;

  @NonNull
  public final TextView albumTitle;

  @NonNull
  public final TextView albumTotalTime;

  @NonNull
  public final AppCompatImageButton append;

  @NonNull
  public final Barrier barrier2;

  @NonNull
  public final ImageView cover;

  @NonNull
  public final AppCompatImageButton delete;

  @NonNull
  public final FrameLayout frameLayout;

  @NonNull
  public final AppCompatImageButton insertNext;

  @NonNull
  public final FocusableRecyclerView mediaList;

  @NonNull
  public final AppCompatImageButton play;

  @Bindable
  protected MediaLibraryItem mItem;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected String mTitle;

  @Bindable
  protected String mSubtitle;

  @Bindable
  protected String mTotalTime;

  @Bindable
  protected int mImageWidth;

  protected ActivityMediaListTvBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatImageButton addPlaylist, TextView albumSubtitle, TextView albumTitle,
      TextView albumTotalTime, AppCompatImageButton append, Barrier barrier2, ImageView cover,
      AppCompatImageButton delete, FrameLayout frameLayout, AppCompatImageButton insertNext,
      FocusableRecyclerView mediaList, AppCompatImageButton play) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addPlaylist = addPlaylist;
    this.albumSubtitle = albumSubtitle;
    this.albumTitle = albumTitle;
    this.albumTotalTime = albumTotalTime;
    this.append = append;
    this.barrier2 = barrier2;
    this.cover = cover;
    this.delete = delete;
    this.frameLayout = frameLayout;
    this.insertNext = insertNext;
    this.mediaList = mediaList;
    this.play = play;
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

  public abstract void setTitle(@Nullable String title);

  @Nullable
  public String getTitle() {
    return mTitle;
  }

  public abstract void setSubtitle(@Nullable String subtitle);

  @Nullable
  public String getSubtitle() {
    return mSubtitle;
  }

  public abstract void setTotalTime(@Nullable String totalTime);

  @Nullable
  public String getTotalTime() {
    return mTotalTime;
  }

  public abstract void setImageWidth(int imageWidth);

  public int getImageWidth() {
    return mImageWidth;
  }

  @NonNull
  public static ActivityMediaListTvBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_media_list_tv, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMediaListTvBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMediaListTvBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.activity_media_list_tv, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMediaListTvBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_media_list_tv, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMediaListTvBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMediaListTvBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.activity_media_list_tv, null, false, component);
  }

  public static ActivityMediaListTvBinding bind(@NonNull View view) {
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
  public static ActivityMediaListTvBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMediaListTvBinding)bind(component, view, org.videolan.vlc.R.layout.activity_media_list_tv);
  }
}
