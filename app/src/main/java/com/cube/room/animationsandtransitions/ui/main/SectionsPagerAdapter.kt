package com.cube.room.animationsandtransitions.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cube.room.animationsandtransitions.animation.drawable.MusicButtonAnimationFragment
import com.cube.room.animationsandtransitions.animation.vector_drawable.BlackShapeAnimationFragment

const val DRAWABLE_MUSIC_BUTTON = 0
const val VECTOR_DRAWABLE_BLACK_SHAPE = 1

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            DRAWABLE_MUSIC_BUTTON -> MusicButtonAnimationFragment.newInstance(position)
            VECTOR_DRAWABLE_BLACK_SHAPE -> BlackShapeAnimationFragment.newInstance(position)
            else -> PlaceholderFragment.newInstance(position + 1)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab ${position + 1}"
    }

    override fun getCount(): Int {
        return 2
    }
}