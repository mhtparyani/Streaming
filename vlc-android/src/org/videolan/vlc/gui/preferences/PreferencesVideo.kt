/*
 * *************************************************************************
 *  PreferencesVideo.java
 * **************************************************************************
 *  Copyright © 2016 VLC authors and VideoLAN
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston MA 02110-1301, USA.
 *  ***************************************************************************
 */

package com.shera.internexttv.gui.preferences

import android.os.Bundle
import androidx.preference.Preference
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import org.videolan.libvlc.util.AndroidUtil
import com.shera.internexttv.R
import com.shera.internexttv.util.POPUP_FORCE_LEGACY
import com.shera.internexttv.util.POPUP_KEEPSCREEN

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class PreferencesVideo : BasePreferenceFragment() {

    override fun getXml() = R.xml.preferences_video

    override fun getTitleId() = R.string.video_prefs_category

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findPreference<Preference>(POPUP_KEEPSCREEN)?.isVisible = !AndroidUtil.isOOrLater
        findPreference<Preference>(POPUP_FORCE_LEGACY)?.isVisible = AndroidUtil.isOOrLater
    }
}
