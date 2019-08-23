package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.lang.Deprecated;
import java.lang.Object;
import com.shera.internexttv.gui.MultiSelectionSpinner;
import com.shera.internexttv.viewmodels.SubtitlesModel;

public abstract class SubtitleDownloadFragmentBinding extends ViewDataBinding {
  @NonNull
  public final Barrier barrier;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final EditText episode;

  @NonNull
  public final MultiSelectionSpinner languageListSpinner;

  @NonNull
  public final TextView languagesList;

  @NonNull
  public final Guideline leftVerticalGuideline;

  @NonNull
  public final CheckBox manualSearchCheckBox;

  @NonNull
  public final Group manualSearchGroup;

  @NonNull
  public final TextView message;

  @NonNull
  public final EditText name;

  @NonNull
  public final Guideline rightVerticalGuideline;

  @NonNull
  public final NestedScrollView scrollView;

  @NonNull
  public final Button searchButton;

  @NonNull
  public final EditText season;

  @NonNull
  public final RecyclerView subtitleList;

  @NonNull
  public final SwipeRefreshLayout swipeContainer;

  @NonNull
  public final Guideline topHorizontalGuideline;

  @Bindable
  protected SubtitlesModel mViewmodel;

  protected SubtitleDownloadFragmentBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Barrier barrier, ConstraintLayout constraintLayout, EditText episode,
      MultiSelectionSpinner languageListSpinner, TextView languagesList,
      Guideline leftVerticalGuideline, CheckBox manualSearchCheckBox, Group manualSearchGroup,
      TextView message, EditText name, Guideline rightVerticalGuideline,
      NestedScrollView scrollView, Button searchButton, EditText season, RecyclerView subtitleList,
      SwipeRefreshLayout swipeContainer, Guideline topHorizontalGuideline) {
    super(_bindingComponent, _root, _localFieldCount);
    this.barrier = barrier;
    this.constraintLayout = constraintLayout;
    this.episode = episode;
    this.languageListSpinner = languageListSpinner;
    this.languagesList = languagesList;
    this.leftVerticalGuideline = leftVerticalGuideline;
    this.manualSearchCheckBox = manualSearchCheckBox;
    this.manualSearchGroup = manualSearchGroup;
    this.message = message;
    this.name = name;
    this.rightVerticalGuideline = rightVerticalGuideline;
    this.scrollView = scrollView;
    this.searchButton = searchButton;
    this.season = season;
    this.subtitleList = subtitleList;
    this.swipeContainer = swipeContainer;
    this.topHorizontalGuideline = topHorizontalGuideline;
  }

  public abstract void setViewmodel(@Nullable SubtitlesModel viewmodel);

  @Nullable
  public SubtitlesModel getViewmodel() {
    return mViewmodel;
  }

  @NonNull
  public static SubtitleDownloadFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.subtitle_download_fragment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SubtitleDownloadFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SubtitleDownloadFragmentBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.subtitle_download_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static SubtitleDownloadFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.subtitle_download_fragment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SubtitleDownloadFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SubtitleDownloadFragmentBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.subtitle_download_fragment, null, false, component);
  }

  public static SubtitleDownloadFragmentBinding bind(@NonNull View view) {
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
  public static SubtitleDownloadFragmentBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (SubtitleDownloadFragmentBinding)bind(component, view, org.videolan.vlc.R.layout.subtitle_download_fragment);
  }
}
