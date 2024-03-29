package com.shera.internexttv.gui.dialogs

import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.isActive
import org.videolan.tools.coroutineScope
import com.shera.internexttv.R
import com.shera.internexttv.databinding.SubtitleDownloaderDialogBinding
import com.shera.internexttv.gui.DialogActivity
import com.shera.internexttv.gui.helpers.UiTools.deleteSubtitleDialog
import com.shera.internexttv.gui.video.VideoPlayerActivity
import com.shera.internexttv.media.MediaUtils
import com.shera.internexttv.util.VLCDownloadManager
import com.shera.internexttv.viewmodels.SubtitlesModel

private const val MEDIA_PATHS = "MEDIA_PATHS"
const val MEDIA_PATH = "MEDIA_PATH"

@ObsoleteCoroutinesApi
class SubtitleDownloaderDialogFragment : DialogFragment() {
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var uris: List<Uri>
    private lateinit var viewModel: SubtitlesModel
    private lateinit var toast: Toast

    val listEventActor = coroutineScope.actor<SubtitleEvent> {
        for (subtitleEvent in channel) if (isActive) when (subtitleEvent) {
            is Click -> when (subtitleEvent.item.state) {
                State.NotDownloaded -> VLCDownloadManager.download(requireActivity(), subtitleEvent.item)
                State.Downloaded -> deleteSubtitleDialog(requireActivity(), DialogInterface.OnClickListener { _, _ -> viewModel.deleteSubtitle(subtitleEvent.item.mediaUri.path, subtitleEvent.item.idSubtitle) }
                        , DialogInterface.OnClickListener { _, _ -> })
                else -> return@actor
            }
            is LongClick -> {
                @StringRes val message = when (subtitleEvent.item.state) {
                    State.NotDownloaded -> R.string.download_the_selected
                    State.Downloaded -> R.string.delete_the_selected
                    // Todo else -> {"Cancel download"}
                    else -> return@actor
                }
                if (::toast.isInitialized) toast.cancel()
                toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.TOP, 0, 100)
                toast.show()
            }
        } else channel.close()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        uris = savedInstanceState?.getParcelableArrayList<Uri>(MEDIA_PATHS)?.toList()
                ?: arguments?.getParcelableArrayList<Uri>(MEDIA_PATHS)?.toList() ?: listOf()
        if (uris.isEmpty()) dismiss()

        viewModel = ViewModelProviders.of(requireActivity(), SubtitlesModel.Factory(requireContext(), uris[0])).get(uris[0].path, SubtitlesModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = SubtitleDownloaderDialogBinding.inflate(inflater, container, false)
        adapter = ViewPagerAdapter(requireContext(), childFragmentManager, uris)
        binding.pager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.pager)

        if (uris.size < 2) {
            binding.nextButton.visibility = View.GONE
            binding.doneButton.visibility = View.VISIBLE
        } else {
            binding.doneButton.visibility = View.GONE
        }

        binding.nextButton.setOnClickListener {
            if (uris.size > 1)
                MediaUtils.showSubtitleDownloaderDialogFragment(requireActivity(), uris.takeLast(uris.size - 1))
            dismiss()
        }
        binding.doneButton.setOnClickListener {
            dismiss()
        }

        binding.movieName.text = uris[0].lastPathSegment

        return binding.root
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // In manifest for VideoPlayerActivity defined
        // android:configChanges="orientation|screenSize|smallestScreenSize|screenLayout"
        // so dialog size breaks on orientation
        if (requireActivity() is VideoPlayerActivity) {
            MediaUtils.showSubtitleDownloaderDialogFragment(requireActivity(), uris)
            dismiss()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(MEDIA_PATHS, ArrayList(uris))
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as? DialogActivity)?.finish()
    }

    companion object {
        fun newInstance(mediaUris: List<Uri>): SubtitleDownloaderDialogFragment {
            val subtitleDownloaderDialogFragment = SubtitleDownloaderDialogFragment()

            val args = Bundle().apply { putParcelableArrayList(MEDIA_PATHS, ArrayList(mediaUris)) }
            subtitleDownloaderDialogFragment.arguments = args
            return subtitleDownloaderDialogFragment
        }
    }

    class ViewPagerAdapter(context: Context, fragmentManager: FragmentManager, private val uris: List<Uri>) : FragmentPagerAdapter(fragmentManager) {
        private val tabTitles = arrayOf(context.getString(R.string.download), context.getString(R.string.history))

        override fun getPageTitle(position: Int): String? = tabTitles[position]

        override fun getItem(position: Int) = when (position) {
            0 -> SubtitleDownloadFragment.newInstance(uris[0])
            else -> SubtitleHistoryFragment.newInstance(uris[0])
        }

        override fun getCount() = 2
    }
}
