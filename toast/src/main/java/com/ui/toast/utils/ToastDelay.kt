package com.ui.toast.utils

sealed class ToastDelay(val duration: Long) {
    object ShortDelay: ToastDelay(2000)
    object LongDelay: ToastDelay(3500)
}