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
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.interfaces.media.AbstractMediaWrapper;
import com.shera.internexttv.gui.video.VideoListAdapter;

public abstract class VideoListCardBinding extends ViewDataBinding {
  @NonNull
  public final ImageView itemMore;

  @NonNull
  public final ImageView mlItemOverlay;

  @NonNull
  public final ProgressBar mlItemProgress;

  @NonNull
  public final ImageView mlItemSeen;

  @NonNull
  public final ImageView mlItemThumbnail;

  @NonNull
  public final TextView mlItemTime;

  @NonNull
  public final TextView mlItemTitle;

  @Bindable
  protected AbstractMediaWrapper mMedia;

  @Bindable
  protected long mSeen;

  @Bindable
  protected String mTime;

  @Bindable
  protected ObservableBoolean mShowFilename;

  @Bindable
  protected int mBgColor;

  @Bindable
  protected int mMax;

  @Bindable
  protected int mProgress;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected ImageView.ScaleType mScaleType;

  @Bindable
  protected VideoListAdapter.ViewHolder mHolder;

  protected VideoListCardBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView itemMore, ImageView mlItemOverlay, ProgressBar mlItemProgress, ImageView mlItemSeen,
      ImageView mlItemThumbnail, TextView mlItemTime, TextView mlItemTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemMore = itemMore;
    this.mlItemOverlay = mlItemOverlay;
    this.mlItemProgress = mlItemProgress;
    this.mlItemSeen = mlItemSeen;
    this.mlItemThumbnail = mlItemThumbnail;
    this.mlItemTime = mlItemTime;
    this.mlItemTitle = mlItemTitle;
  }

  public abstract void setMedia(@Nullable AbstractMediaWrapper media);

  @Nullable
  public AbstractMediaWrapper getMedia() {
    return mMedia;
  }

  public abstract void setSeen(long seen);

  public long getSeen() {
    return mSeen;
  }

  public abstract void setTime(@Nullable String time);

  @Nullable
  public String getTime() {
    return mTime;
  }

  public abstract void setShowFilename(@Nullable ObservableBoolean showFilename);

  @Nullable
  public ObservableBoolean getShowFilename() {
    return mShowFilename;
  }

  public abstract void setBgColor(int bgColor);

  public int getBgColor() {
    return mBgColor;
  }

  public abstract void setMax(int max);

  public int getMax() {
    return mMax;
  }

  public abstract void setProgress(int progress);

  public int getProgress() {
    return mProgress;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  public abstract void setScaleType(@Nullable ImageView.ScaleType scaleType);

  @Nullable
  public ImageView.ScaleType getScaleType() {
    return mScaleType;
  }

  public abstract void setHolder(@Nullable VideoListAdapter.ViewHolder holder);

  @Nullable
  public VideoListAdapter.ViewHolder getHolder() {
    return mHolder;
  }

  @NonNull
  public static VideoListCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.video_list_card, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static VideoListCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<VideoListCardBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.video_list_card, root, attachToRoot, component);
  }

  @NonNull
  public static VideoListCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.video_list_card, null, false, component)
   */
  @NonNull
  @Deprecated
  public static VideoListCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<VideoListCardBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.video_list_card, null, false, component);
  }

  public static VideoListCardBinding bind(@NonNull View view) {
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
  public static VideoListCardBinding bind(@NonNull View view, @Nullable Object component) {
    return (VideoListCardBinding)bind(component, view, org.videolan.vlc.R.layout.video_list_card);
  }
}
