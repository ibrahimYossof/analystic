package com.example.analyses

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        analytics = Firebase.analytics

        findViewById<Button>(R.id.btn_event).setOnClickListener {
            selectContentEvent("Image","btn","image")
        }
        findViewById<Button>(R.id.btn_Sc_event).setOnClickListener{
            trackScreenEvent()
        }


    }
    fun selectContentEvent(name:String,id:String,type:String){
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){
            param(FirebaseAnalytics.Param.ITEM_ID,id)
            param(FirebaseAnalytics.Param.ITEM_NAME, name)
            param(FirebaseAnalytics.Param.CONTENT_TYPE,type)
        }
    }

    fun trackScreenEvent(){
        analytics. logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){
            param (FirebaseAnalytics.Param. SCREEN_NAME, "main")
            param(FirebaseAnalytics.Param.SCREEN_NAME,"MainActivity")
    }
    }



    }