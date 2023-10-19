package com.example.myapplication_lab1

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class UserActivity : ComponentActivity() {

    private val USER_NAME_EXTRA = "USER_NAME_EXTRA"
    private val NUMBER_RECEIVER_ACTION = "NUMBER_RECEIVER_ACTION"
    private val numberReceiver = NumberReceiver()
    private val filter = IntentFilter(NUMBER_RECEIVER_ACTION)
    private var name: String = ""
    public override fun onResume() {
        super.onResume()
        registerReceiver(numberReceiver, filter)
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(numberReceiver)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val start = findViewById<Button>(R.id.StartBt)
        val stop = findViewById<Button>(R.id.StopBt)

        this.name = intent.getStringExtra("text").toString()
        val textView = findViewById<TextView>(R.id.textViewUA)

        textView.text = "Hello ".plus(this.name)

        start.setOnClickListener {
            this.onStartServiceBtnClick()
        }

        stop.setOnClickListener {
            this.onStopServiceBtnClick()
        }

    }

    private fun onStartServiceBtnClick() {
        val intent = Intent(this, MyService::class.java)
        intent.putExtra(USER_NAME_EXTRA, this.name)
        startService(intent)
    }
    private fun onStopServiceBtnClick() {
        val intent = Intent(this, MyService::class.java)
        stopService(intent)
    }
}