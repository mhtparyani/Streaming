package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.tv.MediaHeaderAdapter;

public abstract class SongHeaderItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView header;

  @Bindable
  protected String mHeaderText;

  @Bindable
  protected Boolean mHasContent;

  @Bindable
  protected MediaHeaderAdapter.ViewHolder mHolder;

  protected SongHeaderItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView header) {
    super(_bindingComponent, _root, _localFieldCount);
    this.header = header;
  }

  public abstract void setHeaderText(@Nullable String headerText);

  @Nullable
  public String getHeaderText() {
    return mHeaderText;
  }

  public abstract void setHasContent(@Nullable Boolean hasContent);

  @Nullable
  public Boolean getHasContent() {
    return mHasContent;
  }

  public abstract void setHolder(@Nullable MediaHeaderAdapter.ViewHolder holder);

  @Nullable
  public MediaHeaderAdapter.ViewHolder getHolder() {
    return mHolder;
  }

  @NonNull
  public static SongHeaderItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.song_header_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SongHeaderItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SongHeaderItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.song_header_item, root, attachToRoot, component);
  }

  @NonNull
  public static SongHeaderItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.song_header_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SongHeaderItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SongHeaderItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.song_header_item, null, false, component);
  }

  public static SongHeaderItemBinding bind(@NonNull View view) {
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
  public static SongHeaderItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (SongHeaderItemBinding)bind(component, view, org.videolan.vlc.R.layout.song_header_item);
  }
}
