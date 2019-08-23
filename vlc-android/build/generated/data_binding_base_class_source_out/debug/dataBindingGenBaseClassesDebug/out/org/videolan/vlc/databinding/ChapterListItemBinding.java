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
import com.shera.internexttv.gui.dialogs.SelectChapterDialog;

public abstract class ChapterListItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView chapterTime;

  @NonNull
  public final TextView chapterTitle;

  @Bindable
  protected Boolean mSelected;

  @Bindable
  protected SelectChapterDialog.Chapter mChapter;

  @Bindable
  protected SelectChapterDialog.ChapterViewHolder mHolder;

  protected ChapterListItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView chapterTime, TextView chapterTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.chapterTime = chapterTime;
    this.chapterTitle = chapterTitle;
  }

  public abstract void setSelected(@Nullable Boolean selected);

  @Nullable
  public Boolean getSelected() {
    return mSelected;
  }

  public abstract void setChapter(@Nullable SelectChapterDialog.Chapter chapter);

  @Nullable
  public SelectChapterDialog.Chapter getChapter() {
    return mChapter;
  }

  public abstract void setHolder(@Nullable SelectChapterDialog.ChapterViewHolder holder);

  @Nullable
  public SelectChapterDialog.ChapterViewHolder getHolder() {
    return mHolder;
  }

  @NonNull
  public static ChapterListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.chapter_list_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ChapterListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ChapterListItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.chapter_list_item, root, attachToRoot, component);
  }

  @NonNull
  public static ChapterListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.chapter_list_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ChapterListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ChapterListItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.chapter_list_item, null, false, component);
  }

  public static ChapterListItemBinding bind(@NonNull View view) {
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
  public static ChapterListItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (ChapterListItemBinding)bind(component, view, org.videolan.vlc.R.layout.chapter_list_item);
  }
}
