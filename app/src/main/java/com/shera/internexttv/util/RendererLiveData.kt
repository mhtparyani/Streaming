package com.shera.internexttv.util

import androidx.lifecycle.MutableLiveData
import org.videolan.libvlc.RendererItem


class RendererLiveData : MutableLiveData<RendererItem>() {

    override fun setValue(value: RendererItem?) {
        getValue()?.release()
        value?.retain()
        super.setValue(value)
    }
}