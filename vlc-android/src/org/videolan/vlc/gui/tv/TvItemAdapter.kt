package com.shera.internexttv.gui.tv

interface TvItemAdapter : TvFocusableAdapter {
    fun submitList(pagedList: Any?)

    var focusNext: Int
}
