package com.cube.room.animationsandtransitions.animation.vector_drawable

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cube.room.animationsandtransitions.R

/**
 * Fragment with Vector Drawable Animation (Black Shape)
 */
class BlackShapeAnimationFragment : Fragment() {

    private lateinit var viewModel: BlackShapeViewModel
    private var shapeVectorDrawable: AnimatedVectorDrawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlackShapeViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_black_shape_animation, container, false)
        val labelTextView: TextView = root.findViewById(R.id.section_label)
        val descTextView: TextView = root.findViewById(R.id.section_desc)
        val musicButtonImageView: ImageView? = root.findViewById(R.id.animation_image_view)

        viewModel.label.observe(viewLifecycleOwner, Observer<String> {
            labelTextView.text = it
        })

        viewModel.desc.observe(viewLifecycleOwner, Observer<String> {
            descTextView.text = it
        })

        musicButtonImageView?.background?.let {
            shapeVectorDrawable = it as AnimatedVectorDrawable
        }

        return root
    }

    override fun onStart() {
        super.onStart()

        shapeVectorDrawable?.start()
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
        fun newInstance(sectionNumber: Int): BlackShapeAnimationFragment {
            return BlackShapeAnimationFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}