package com.shera.internexttv.databinding;

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
import com.shera.internexttv.gui.helpers.PlayerOption;

public abstract class PlayerOptionItemBinding extends ViewDataBinding {
  @NonNull
  public final ImageView optionIcon;

  @NonNull
  public final TextView optionTitle;

  @Bindable
  protected PlayerOption mOption;

  protected PlayerOptionItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView optionIcon, TextView optionTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.optionIcon = optionIcon;
    this.optionTitle = optionTitle;
  }

  public abstract void setOption(@Nullable PlayerOption option);

  @Nullable
  public PlayerOption getOption() {
    return mOption;
  }

  @NonNull
  public static PlayerOptionItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.player_option_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PlayerOptionItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PlayerOptionItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.player_option_item, root, attachToRoot, component);
  }

  @NonNull
  public static PlayerOptionItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.player_option_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PlayerOptionItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PlayerOptionItemBinding>inflateInternal(inflater, org.videolan.vlc.R.layout.player_option_item, null, false, component);
  }

  public static PlayerOptionItemBinding bind(@NonNull View view) {
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
  public static PlayerOptionItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (PlayerOptionItemBinding)bind(component, view, org.videolan.vlc.R.layout.player_option_item);
  }
}
