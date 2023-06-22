package com.example.timerestart.operation

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.random.Random

class TimerOperation {
    var randomizedBoolean = false

    suspend operator fun invoke(
    ): Boolean = withContext(
        Dispatchers.IO
    ){
        val timedBoolean = timedExit()
        Log.e("OPERATION", "randomized boolean = $timedBoolean")
        timedBoolean ?: false
    }

    private suspend fun timedExit(
    ): Boolean? {
        val timeBoolean = withTimeoutOrNull(4000) {
            randomizedTimerBoolean()
        }
        return timeBoolean
    }

    private suspend fun randomizedTimerBoolean(
    ): Boolean {
        val randomTimer = Random.nextInt(1, 20)
        Log.e("OPERATION", "random timer = $randomTimer")
        delay((randomTimer*1000).toLong())
        randomizedBoolean = true
        Log.e("OPERATION", "random timer completed")
        return true
    }
}
