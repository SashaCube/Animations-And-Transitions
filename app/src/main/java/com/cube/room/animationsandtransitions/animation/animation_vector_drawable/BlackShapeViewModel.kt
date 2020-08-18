package com.cube.room.animationsandtransitions.animation.animation_vector_drawable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel


class BlackShapeViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val label: LiveData<String> = Transformations.map(_index) {
        "Animation : $it - Vector Drawable Black Rect"
    }

    val desc: LiveData<String> = MutableLiveData<String>(
        "A vector drawable is a type of drawable that is scalable " +
                "without getting pixelated or blurry. The AnimatedVectorDrawable " +
                "class (and AnimatedVectorDrawableCompat for backward-compatibility) " +
                "lets you animate the properties of a vector drawable, such as rotating " +
                "it or changing the path data to morph it into a different image. "
    )

    fun setIndex(index: Int) {
        _index.value = index
    }
}