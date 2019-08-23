package com.shera.internexttv.databinding;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.interfaces.media.AbstractMediaWrapper;
import com.shera.internexttv.gui.tv.details.MediaListAdapter;

public abstract class ActivityMediaListTvItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout container;

  @NonNull
  public final ImageView cover;

  @NonNull
  public final AppCompatImageButton itemAddPlaylist;

  @NonNull
  public final AppCompatImageButton itemAppend;

  @NonNull
  public final AppCompatImageButton itemInsertNext;

  @NonNull
  public final AppCompatImageButton itemMoveDown;

  @NonNull
  public final AppCompatImageButton itemMoveUp;

  @NonNull
  public final AppCompatImageView itemPlay;

  @NonNull
  public final AppCompatImageButton itemRemove;

  @NonNull
  public final View itemSelector;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView17;

  @NonNull
  public final TextView title;

  @Bindable
  protected AbstractMediaWrapper mItem;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected MediaListAdapter.MediaListViewHolder mHolder;

  protected ActivityMediaListTvItemBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout container, ImageView cover,
      AppCompatImageButton itemAddPlaylist, AppCompatImageButton itemAppend,
      AppCompatImageButton itemInsertNext, AppCompatImageButton itemMoveDown,
      AppCompatImageButton itemMoveUp, AppCompatImageView itemPlay, AppCompatImageButton itemRemove,
      View itemSelector, TextView textView16, TextView textView17, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.container = container;
    this.cover = cover;
    this.itemAddPlaylist = itemAddPlaylist;
    this.itemAppend = itemAppend;
    this.itemInsertNext = itemInsertNext;
    this.itemMoveDown = itemMoveDown;
    this.itemMoveUp = itemMoveUp;
    this.itemPlay = itemPlay;
    this.itemRemove = itemRemove;
    this.itemSelector = itemSelector;
    this.textView16 = textView16;
    this.textView17 = textView17;
    this.title = title;
  }

  public abstract void setItem(@Nullable AbstractMediaWrapper item);

  @Nullable
  public AbstractMediaWrapper getItem() {
    return mItem;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  public abstract void setHolder(@Nullable MediaListAdapter.MediaListViewHolder holder);

  @Nullable
  public MediaListAdapter.MediaListViewHolder getHolder() {
    return mHolder;
  }

  @NonNull
  public static ActivityMediaListTvItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_media_list_tv_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMediaListTvItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMediaListTvItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.activity_media_list_tv_item, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMediaListTvItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_media_list_tv_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMediaListTvItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMediaListTvItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.activity_media_list_tv_item, null, false, component);
  }

  public static ActivityMediaListTvItemBinding bind(@NonNull View view) {
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
  public static ActivityMediaListTvItemBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityMediaListTvItemBinding)bind(component, view, org.videolan.vlc.R.layout.activity_media_list_tv_item);
  }
}
