package com.example.timerestart.operation

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.properties.Delegates
import kotlin.random.Random

class TimerOperation {
    private val lock = Mutex(locked = true)

    private var randomizedBoolean by Delegates.observable(false) { _, _, newValue ->
        Log.e("OPERATION", "new value: $newValue")
        lock.unlock()
    }

    suspend operator fun invoke(
    ): Boolean = withContext(
        Dispatchers.IO
    ){
        launch(Dispatchers.Default) {
            randomizedTimerBoolean()
        }
        timedLock()
        Log.e("OPERATION", "randomized boolean = $randomizedBoolean")
        randomizedBoolean
    }

    private suspend fun timedLock(
    ) {
        Log.e("OPERATION", "timedLock - START")
        withTimeoutOrNull(6000) {
            launch(Dispatchers.Default) {
                Log.e("OPERATION", "LOCKED")
                lock.lock()
                Log.e("OPERATION", "UNLOCKED")
            }
        }
        Log.e("OPERATION", "timedLock - END")
    }

    private suspend fun randomizedTimerBoolean(
    ) {
        val randomTimer = Random.nextInt(1, 20)
        Log.e("OPERATION", "random timer = $randomTimer")
        delay((randomTimer*1000).toLong())
        randomizedBoolean = true
        Log.e("OPERATION", "random timer completed")
    }
}
