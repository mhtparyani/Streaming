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
import org.videolan.medialibrary.interfaces.media.AbstractFolder;
import com.shera.internexttv.gui.folders.FoldersAdapter;

public abstract class FolderItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView folderDesc;

  @NonNull
  public final ImageView folderImage;

  @NonNull
  public final ImageView folderMore;

  @NonNull
  public final TextView folderName;

  @Bindable
  protected AbstractFolder mFolder;

  @Bindable
  protected int mBgColor;

  @Bindable
  protected BitmapDrawable mCover;

  @Bindable
  protected FoldersAdapter.ViewHolder mHolder;

  protected FolderItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView folderDesc, ImageView folderImage, ImageView folderMore, TextView folderName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.folderDesc = folderDesc;
    this.folderImage = folderImage;
    this.folderMore = folderMore;
    this.folderName = folderName;
  }

  public abstract void setFolder(@Nullable AbstractFolder folder);

  @Nullable
  public AbstractFolder getFolder() {
    return mFolder;
  }

  public abstract void setBgColor(int bgColor);

  public int getBgColor() {
    return mBgColor;
  }

  public abstract void setCover(@Nullable BitmapDrawable cover);

  @Nullable
  public BitmapDrawable getCover() {
    return mCover;
  }

  public abstract void setHolder(@Nullable FoldersAdapter.ViewHolder holder);

  @Nullable
  public FoldersAdapter.ViewHolder getHolder() {
    return mHolder;
  }

  @NonNull
  public static FolderItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.folder_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FolderItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FolderItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.folder_item, root, attachToRoot, component);
  }

  @NonNull
  public static FolderItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.folder_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FolderItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FolderItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.folder_item, null, false, component);
  }

  public static FolderItemBinding bind(@NonNull View view) {
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
  public static FolderItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (FolderItemBinding)bind(component, view, org.videolan.vlc.R.layout.folder_item);
  }
}
