package com.cube.room.animationsandtransitions.animation.animation_drawable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel


class MusicButtonViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val label: LiveData<String> = Transformations.map(_index) {
        "Animation : $it - Drawable Music Button"
    }

    val desc: LiveData<String> = MutableLiveData<String>(
        "One way to animate Drawables is to load a series of Drawable " +
                "resources one after another to create an animation. This is a " +
                "traditional animation in the sense that it is created with a " +
                "sequence of different images, played in order, like a roll of film. " +
                "The AnimationDrawable class is the basis for Drawable animations."
    )

    fun setIndex(index: Int) {
        _index.value = index
    }
}