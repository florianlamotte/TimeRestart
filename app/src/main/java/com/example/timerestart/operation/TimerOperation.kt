package com.example.timerestart.operation

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class TimerOperation {
    var randomizedBoolean = false

    suspend operator fun invoke(
    ): Boolean = withContext(
        Dispatchers.IO
    ){
        launch {
            randomizedTimerBoolean()
        }
        delay(4000)
        Log.e("OPERATION", "randomized boolean = $randomizedBoolean")
        randomizedBoolean
    }

    private suspend fun randomizedTimerBoolean(
    ){
        val randomTimer = Random.nextInt(1, 10)
        Log.e("OPERATION", "random timer = $randomTimer")
        delay((randomTimer*1000).toLong())
        randomizedBoolean = true
        Log.e("OPERATION", "random timer completed")
    }
}
