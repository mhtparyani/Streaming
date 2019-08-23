package com.shera.internexttv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;
import org.videolan.medialibrary.media.SearchAggregate;
import com.shera.internexttv.gui.SearchActivity;

public abstract class SearchActivityBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView albumsResults;

  @NonNull
  public final RecyclerView artistsResults;

  @NonNull
  public final RecyclerView episodesResults;

  @NonNull
  public final RecyclerView genresResults;

  @NonNull
  public final RecyclerView moviesResults;

  @NonNull
  public final RecyclerView othersResults;

  @NonNull
  public final RecyclerView playlistsResults;

  @NonNull
  public final LinearLayout resultsContainer;

  @NonNull
  public final TextInputLayout searchEditLayout;

  @NonNull
  public final EditText searchEditText;

  @NonNull
  public final RecyclerView songsResults;

  @Bindable
  protected SearchAggregate mSearchAggregate;

  @Bindable
  protected SearchActivity.ClickHandler mHandler;

  protected SearchActivityBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView albumsResults, RecyclerView artistsResults, RecyclerView episodesResults,
      RecyclerView genresResults, RecyclerView moviesResults, RecyclerView othersResults,
      RecyclerView playlistsResults, LinearLayout resultsContainer,
      TextInputLayout searchEditLayout, EditText searchEditText, RecyclerView songsResults) {
    super(_bindingComponent, _root, _localFieldCount);
    this.albumsResults = albumsResults;
    this.artistsResults = artistsResults;
    this.episodesResults = episodesResults;
    this.genresResults = genresResults;
    this.moviesResults = moviesResults;
    this.othersResults = othersResults;
    this.playlistsResults = playlistsResults;
    this.resultsContainer = resultsContainer;
    this.searchEditLayout = searchEditLayout;
    this.searchEditText = searchEditText;
    this.songsResults = songsResults;
  }

  public abstract void setSearchAggregate(@Nullable SearchAggregate searchAggregate);

  @Nullable
  public SearchAggregate getSearchAggregate() {
    return mSearchAggregate;
  }

  public abstract void setHandler(@Nullable SearchActivity.ClickHandler handler);

  @Nullable
  public SearchActivity.ClickHandler getHandler() {
    return mHandler;
  }

  @NonNull
  public static SearchActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.search_activity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SearchActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SearchActivityBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.search_activity, root, attachToRoot, component);
  }

  @NonNull
  public static SearchActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.search_activity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SearchActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SearchActivityBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.search_activity, null, false, component);
  }

  public static SearchActivityBinding bind(@NonNull View view) {
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
  public static SearchActivityBinding bind(@NonNull View view, @Nullable Object component) {
    return (SearchActivityBinding)bind(component, view, org.videolan.vlc.R.layout.search_activity);
  }
}
