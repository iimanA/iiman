package com.example.assign1

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
fun Long.toMonthDay(): String {
    val dateFormatter = DateTimeFormatter.ofPattern("MMM dd")
    val dateTime = LocalDateTime.ofEpochSecond(this, 0, ZoneOffset.of("-5"))
    return dateFormatter.format(dateTime)
}

@RequiresApi(Build.VERSION_CODES.O)
fun Long.toHourMinute():String{
    val dataFormatter = DateTimeFormatter.ofPattern("h:mm a")
    val dateTime = LocalDateTime.ofEpochSecond(this,0, ZoneOffset.of("-6"))
    return dataFormatter.format(dateTime)
}