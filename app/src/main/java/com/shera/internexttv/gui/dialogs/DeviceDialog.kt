package com.shera.internexttv.gui.dialogs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.coroutines.*
import com.shera.internexttv.R
import com.shera.internexttv.StartActivity
import com.shera.internexttv.databinding.DialogExtDeviceBinding
import com.shera.internexttv.gui.helpers.MedialibraryUtils
import com.shera.internexttv.util.EXTRA_PATH

private const val TAG = "VLC/DeviceDialog"

class DeviceDialog : DialogFragment(), CoroutineScope by MainScope() {

    private lateinit var path : String
    private lateinit var uuid : String
    private var scan = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, 0)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.setTitle(getString(R.string.device_dialog_title))
        val binding = DialogExtDeviceBinding.inflate(inflater, container, false)
        binding.handler = clickHandler
        if (scan) binding.extDeviceScan.visibility = View.VISIBLE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launch {
            delay(30_000L)
            dismissAllowingStateLoss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
        activity?.finish()
    }


    fun setDevice(path: String, uuid: String, scan: Boolean) {
        this.path = path
        this.uuid = uuid
        this.scan = scan
    }

    private val clickHandler = object : ExtDeviceHandler {
        override fun browse(v: View) {
            context?.applicationContext?.let {
                it.startActivity(Intent(it, StartActivity::class.java).putExtra(EXTRA_PATH, path).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            }
            dismiss()
        }

        override fun scan(v: View) {
            context?.let {
                MedialibraryUtils.addDevice(path, it.applicationContext)
                it.startActivity(Intent(it, StartActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            }
            dismiss()
        }

        override fun cancel(v: View) {
            dismiss()
        }

    }
}

interface ExtDeviceHandler {
    fun browse(v: View)
    fun scan(v: View)
    fun cancel(v: View)
}