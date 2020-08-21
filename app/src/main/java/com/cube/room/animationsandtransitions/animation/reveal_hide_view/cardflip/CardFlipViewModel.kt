package com.cube.room.animationsandtransitions.animation.reveal_hide_view.cardflip

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class CardFlipViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val label: LiveData<String> = Transformations.map(_index) {
        "Animation : $it - View Card Flip "
    }

    val desc: LiveData<String> = MutableLiveData<String>(
        "Card flips animate between views of content by showing an " +
                "animation that emulates a card flipping over. The card flip "
    )

    fun setIndex(index: Int) {
        _index.value = index
    }
}