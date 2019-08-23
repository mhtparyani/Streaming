package com.shera.internexttv.gui.tv

/**
 * Callback used when the adapter is used in a [FocusableRecyclerView]
 */
interface TvFocusableAdapter {
    fun setOnFocusChangeListener(focusListener: FocusableRecyclerView.FocusListener?)
}