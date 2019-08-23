package com.shera.internexttv.databinding;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.interfaces.media.AbstractMediaWrapper;
import com.shera.internexttv.gui.HistoryAdapter;

public abstract class HistoryItemBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout constraintLayout4;

  @NonNull
  public final ImageView icon;

  @NonNull
  public final ImageView songMarker;

  @NonNull
  public final TextView subtitle;

  @NonNull
  public final TextView title;

  @Bindable
  protected HistoryAdapter.ViewHolder mHolder;

  @Bindable
  protected AbstractMediaWrapper mMedia;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected int mBgColor;

  protected HistoryItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout constraintLayout4, ImageView icon, ImageView songMarker, TextView subtitle,
      TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.constraintLayout4 = constraintLayout4;
    this.icon = icon;
    this.songMarker = songMarker;
    this.subtitle = subtitle;
    this.title = title;
  }

  public abstract void setHolder(@Nullable HistoryAdapter.ViewHolder holder);

  @Nullable
  public HistoryAdapter.ViewHolder getHolder() {
    return mHolder;
  }

  public abstract void setMedia(@Nullable AbstractMediaWrapper media);

  @Nullable
  public AbstractMediaWrapper getMedia() {
    return mMedia;
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

  @NonNull
  public static HistoryItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.history_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static HistoryItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<HistoryItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.history_item, root, attachToRoot, component);
  }

  @NonNull
  public static HistoryItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.history_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static HistoryItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<HistoryItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.history_item, null, false, component);
  }

  public static HistoryItemBinding bind(@NonNull View view) {
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
  public static HistoryItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (HistoryItemBinding)bind(component, view, org.videolan.vlc.R.layout.history_item);
  }
}
