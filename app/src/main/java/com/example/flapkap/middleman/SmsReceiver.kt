package com.example.flapkap.middleman

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log
import android.provider.Telephony

private const val TAG = "SmsReceiver"

private val SMS_RECEIVED_ACTION = Telephony.Sms.Intents.SMS_RECEIVED_ACTION
private val SMS_DELIVERED_ACTION = Telephony.Sms.Intents.SMS_DELIVER_ACTION

data class Sms(val phone: String, val message: String)

class SmsReceiver: BroadcastReceiver(){


    override fun onReceive(context: Context?, intent: Intent?) {
        val pdus = intent?.extras?.get("pdus") as Array<*>
        val message = SmsMessage.createFromPdu(pdus[0] as ByteArray, intent.extras?.getString("format"))
        val sms = Sms(
                phone = message.displayOriginatingAddress,
                message = message.messageBody
        )
        Log.i(TAG, sms.toString())
    }

}