package com.example.myapplication_lab1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class NumberReceiver : BroadcastReceiver() {

    private val NUMBER_EXTRA = "NUMBER_EXTRA"
    private val USER_NAME_EXTRA = "USER_NAME_EXTRA"

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        //
        val number = intent.getIntExtra(NUMBER_EXTRA, 0)
        val user = intent.getStringExtra(USER_NAME_EXTRA)

        Log.d("Received user name: ", user!!)
        Log.d("Received number: ", "" + number)
    }
}