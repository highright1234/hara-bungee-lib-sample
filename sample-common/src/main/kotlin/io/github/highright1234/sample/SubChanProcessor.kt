package io.github.highright1234.sample

import com.google.common.io.ByteArrayDataInput

interface SubChanProcessor<T> {
    fun handle(sender : T, bytes : ByteArrayDataInput)
}