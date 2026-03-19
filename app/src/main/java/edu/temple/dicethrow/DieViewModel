package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {

    private val _dieValue = MutableLiveData<Int>()
    val dieValue: LiveData<Int> = _dieValue

    private var sides: Int = 6

    fun setSides(sides: Int) {
        this.sides = sides
        rollDie()
    }

    fun rollDie() {
        _dieValue.value = Random.nextInt(1, sides + 1)
    }
}