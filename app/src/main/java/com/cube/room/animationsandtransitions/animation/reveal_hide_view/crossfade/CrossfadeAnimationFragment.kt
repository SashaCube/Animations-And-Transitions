package com.cube.room.animationsandtransitions.animation.reveal_hide_view.crossfade

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cube.room.animationsandtransitions.R

/**
 * Fragment with Drawable Animation (Music Button)
 */
class CrossfadeAnimationFragment : Fragment() {

    private lateinit var viewModel: CrossfadeViewModel

    private lateinit var contentView: View
    private lateinit var loadingView: View
    private lateinit var root: View
    private lateinit var labelTextView: TextView
    private lateinit var descTextView: TextView

    private lateinit var animationHandler: Handler
    private val animationInterval = 5000L
    private var shortAnimationDuration: Int = 0
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CrossfadeViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_view_crossfade_animation, container, false)

        initViews()
        initObservers()
        initAndStartLoopAnimation()

        return root
    }

    private fun initAndStartLoopAnimation() {
        contentView.visibility = View.GONE
        shortAnimationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)

        animationHandler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            crossfade()
            animationHandler.postDelayed(runnable, animationInterval)
            animationHandler.postDelayed({
                contentView.visibility = View.GONE
                loadingView.apply {
                    visibility = View.VISIBLE
                    alpha = 1f
                }
            }, animationInterval / 2)
        }

        animationHandler.post(runnable)
    }

    private fun crossfade() {
        contentView.apply {
            alpha = 0f
            visibility = View.VISIBLE

            animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(null)
        }

        loadingView.animate()
            .alpha(0f)
            .setDuration(shortAnimationDuration.toLong())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    loadingView.visibility = View.GONE
                }
            })
    }

    private fun initObservers() {
        viewModel.label.observe(viewLifecycleOwner, Observer<String> {
            labelTextView.text = it
        })
        viewModel.desc.observe(viewLifecycleOwner, Observer<String> {
            descTextView.text = it
        })
    }

    private fun initViews() {
        labelTextView = root.findViewById(R.id.section_label)
        descTextView = root.findViewById(R.id.section_desc)
        contentView = root.findViewById(R.id.content)
        loadingView = root.findViewById(R.id.loading_spinner)
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): CrossfadeAnimationFragment {
            return CrossfadeAnimationFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}