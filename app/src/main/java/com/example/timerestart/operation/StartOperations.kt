package com.example.timerestart.operation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StartOperations(
    val timerOperation: TimerOperation,
) {
    suspend operator fun invoke(
    ): Boolean = withContext(Dispatchers.Default) {
        val operation = timerOperation()
        operation
    }
}