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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.media.MediaLibraryItem;
import com.shera.internexttv.gui.tv.FocusableConstraintLayout;
import com.shera.internexttv.gui.tv.MediaTvItemAdapter;
import com.shera.internexttv.gui.view.FadableImageView;

public abstract class MediaBrowserTvItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView badgeTV;

  @NonNull
  public final FocusableConstraintLayout container;

  @NonNull
  public final TextView dviIconTv;

  @NonNull
  public final FadableImageView mediaCover;

  @NonNull
  public final ImageView mlItemSeen;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final AppCompatTextView subtitle;

  @NonNull
  public final AppCompatTextView title;

  @Bindable
  protected int mProgress;

  @Bindable
  protected int mMax;

  @Bindable
  protected String mBadge;

  @Bindable
  protected String mDescription;

  @Bindable
  protected long mSeen;

  @Bindable
  protected MediaLibraryItem mItem;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected Boolean mIsSquare;

  @Bindable
  protected String mProtocol;

  @Bindable
  protected ImageView.ScaleType mScaleType;

  @Bindable
  protected MediaTvItemAdapter.AbstractMediaItemViewHolder mHolder;

  protected MediaBrowserTvItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView badgeTV, FocusableConstraintLayout container, TextView dviIconTv,
      FadableImageView mediaCover, ImageView mlItemSeen, ProgressBar progressBar,
      AppCompatTextView subtitle, AppCompatTextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.badgeTV = badgeTV;
    this.container = container;
    this.dviIconTv = dviIconTv;
    this.mediaCover = mediaCover;
    this.mlItemSeen = mlItemSeen;
    this.progressBar = progressBar;
    this.subtitle = subtitle;
    this.title = title;
  }

  public abstract void setProgress(int progress);

  public int getProgress() {
    return mProgress;
  }

  public abstract void setMax(int max);

  public int getMax() {
    return mMax;
  }

  public abstract void setBadge(@Nullable String badge);

  @Nullable
  public String getBadge() {
    return mBadge;
  }

  public abstract void setDescription(@Nullable String description);

  @Nullable
  public String getDescription() {
    return mDescription;
  }

  public abstract void setSeen(long seen);

  public long getSeen() {
    return mSeen;
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

  public abstract void setIsSquare(@Nullable Boolean isSquare);

  @Nullable
  public Boolean getIsSquare() {
    return mIsSquare;
  }

  public abstract void setProtocol(@Nullable String protocol);

  @Nullable
  public String getProtocol() {
    return mProtocol;
  }

  public abstract void setScaleType(@Nullable ImageView.ScaleType scaleType);

  @Nullable
  public ImageView.ScaleType getScaleType() {
    return mScaleType;
  }

  public abstract void setHolder(@Nullable MediaTvItemAdapter.AbstractMediaItemViewHolder holder);

  @Nullable
  public MediaTvItemAdapter.AbstractMediaItemViewHolder getHolder() {
    return mHolder;
  }

  @NonNull
  public static MediaBrowserTvItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.media_browser_tv_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static MediaBrowserTvItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<MediaBrowserTvItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.media_browser_tv_item, root, attachToRoot, component);
  }

  @NonNull
  public static MediaBrowserTvItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.media_browser_tv_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static MediaBrowserTvItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<MediaBrowserTvItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.media_browser_tv_item, null, false, component);
  }

  public static MediaBrowserTvItemBinding bind(@NonNull View view) {
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
  public static MediaBrowserTvItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (MediaBrowserTvItemBinding)bind(component, view, org.videolan.vlc.R.layout.media_browser_tv_item);
  }
}
