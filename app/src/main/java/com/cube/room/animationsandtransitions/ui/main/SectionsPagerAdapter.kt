package com.cube.room.animationsandtransitions.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cube.room.animationsandtransitions.animation.drawable.MusicButtonAnimationFragment
import com.cube.room.animationsandtransitions.animation.reveal_hide_view.cardflip.CardFlipAnimationFragment
import com.cube.room.animationsandtransitions.animation.reveal_hide_view.crossfade.CrossfadeAnimationFragment
import com.cube.room.animationsandtransitions.animation.vector_drawable.BlackShapeAnimationFragment

const val DRAWABLE_MUSIC_BUTTON = 0
const val VECTOR_DRAWABLE_BLACK_SHAPE = 1
const val VIEW_CROSSFADE = 2
const val VIEW_CARD_FLIP = 3

const val TABS_COUNT = 4

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
            VIEW_CROSSFADE -> CrossfadeAnimationFragment.newInstance(position)
            VIEW_CARD_FLIP -> CardFlipAnimationFragment.newInstance(position)
            else -> PlaceholderFragment.newInstance(position + 1)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab ${position + 1}"
    }

    override fun getCount(): Int {
        return TABS_COUNT
    }
}