package com.shera.internexttv.gui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.shera.internexttv.R
import com.shera.internexttv.gui.browser.StorageBrowserFragment

class OnboardingFoldersFragment : Fragment() {


    private lateinit var storageBrowserFragment: StorageBrowserFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        storageBrowserFragment = StorageBrowserFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.onboarding_folders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title: TextView = view.findViewById(R.id.onboardingFolderTitle)
        val ariane: View = view.findViewById(R.id.ariane)
        ariane.viewTreeObserver.addOnGlobalLayoutListener {
            when (ariane.visibility) {
                View.VISIBLE -> title.visibility = View.GONE
                else -> title.visibility = View.VISIBLE
            }
        }



        requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.fragment_placeholder, storageBrowserFragment)
                .commit()


    }


    companion object {
        fun newInstance(): OnboardingFoldersFragment {
            return OnboardingFoldersFragment()
        }
    }
}