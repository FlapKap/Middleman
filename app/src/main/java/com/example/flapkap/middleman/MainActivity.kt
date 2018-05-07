package com.example.flapkap.middleman

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestReadSMS()

    }

    private fun requestReadSMS(){
        if(this.checkSelfPermission(android.Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED)
            requestPermissions(arrayOf(android.Manifest.permission.RECEIVE_SMS),1)
    }
}
