package com.shera.internexttv.databinding;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.media.MediaLibraryItem;
import com.shera.internexttv.gui.audio.AudioBrowserAdapter;
import com.shera.internexttv.gui.view.FadableImageView;

public abstract class AudioBrowserItemBinding extends ViewDataBinding {
  @NonNull
  public final ImageView itemMore;

  @NonNull
  public final ImageView itemMove;

  @NonNull
  public final FadableImageView mediaCover;

  @NonNull
  public final TextView subtitle;

  @NonNull
  public final TextView title;

  @Bindable
  protected int mAlignMode;

  @Bindable
  protected MediaLibraryItem mItem;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected int mBgColor;

  @Bindable
  protected AudioBrowserAdapter.MediaItemViewHolder mHolder;

  protected AudioBrowserItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView itemMore, ImageView itemMove, FadableImageView mediaCover, TextView subtitle,
      TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemMore = itemMore;
    this.itemMove = itemMove;
    this.mediaCover = mediaCover;
    this.subtitle = subtitle;
    this.title = title;
  }

  public abstract void setAlignMode(int alignMode);

  public int getAlignMode() {
    return mAlignMode;
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

  public abstract void setBgColor(int bgColor);

  public int getBgColor() {
    return mBgColor;
  }

  public abstract void setHolder(@Nullable AudioBrowserAdapter.MediaItemViewHolder holder);

  @Nullable
  public AudioBrowserAdapter.MediaItemViewHolder getHolder() {
    return mHolder;
  }

  @NonNull
  public static AudioBrowserItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.audio_browser_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AudioBrowserItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AudioBrowserItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.audio_browser_item, root, attachToRoot, component);
  }

  @NonNull
  public static AudioBrowserItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.audio_browser_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AudioBrowserItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AudioBrowserItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.audio_browser_item, null, false, component);
  }

  public static AudioBrowserItemBinding bind(@NonNull View view) {
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
  public static AudioBrowserItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (AudioBrowserItemBinding)bind(component, view, org.videolan.vlc.R.layout.audio_browser_item);
  }
}
