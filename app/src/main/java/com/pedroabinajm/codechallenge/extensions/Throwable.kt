package com.pedroabinajm.codechallenge.extensions

import com.pedroabinajm.codechallenge.R
import java.io.IOException

val Throwable.errorType: ErrorType
    get() = when {
        this is IOException -> ErrorType.CONNECTION
        else -> ErrorType.UNEXPECTED
    }

val Throwable.friendlyMessage: Int
    get() = when (errorType) {
        ErrorType.CONNECTION -> R.string.network_error
        else -> R.string.unexpected_error
    }

enum class ErrorType {
    CONNECTION, UNEXPECTED
}