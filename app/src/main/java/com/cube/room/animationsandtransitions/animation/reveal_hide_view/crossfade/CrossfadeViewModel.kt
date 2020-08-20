package com.cube.room.animationsandtransitions.animation.reveal_hide_view.crossfade

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class CrossfadeViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val label: LiveData<String> = Transformations.map(_index) {
        "Animation : $it - View Crossfade "
    }

    val desc: LiveData<String> = MutableLiveData<String>(
        "Crossfade animations (also known as dissolve) gradually fade out" +
                " one View or ViewGroup while simultaneously fading in another. " +
                "This animation is useful for situations where you want to switch " +
                "content or views in your app."
    )

    fun setIndex(index: Int) {
        _index.value = index
    }
}