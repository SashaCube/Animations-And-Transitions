package com.cube.room.animationsandtransitions.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cube.room.animationsandtransitions.R
import com.cube.room.animationsandtransitions.animation.animation_drawable.MusicButtonAnimationFragment

const val DRAWABLE_MUSIC_BUTTON = 0

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            DRAWABLE_MUSIC_BUTTON -> MusicButtonAnimationFragment.newInstance(position)
            else  -> PlaceholderFragment.newInstance(position + 1)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab ${position + 1}"
    }

    override fun getCount(): Int {
        return 2
    }
}