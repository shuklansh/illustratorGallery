package com.ShuklAnsh.appone

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {
    lateinit var toDark : Button
    lateinit var toLight: Button
    lateinit var sharedPreferences: SharedPreferences
    var username:String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar?.hide()
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),
            Context.MODE_PRIVATE)
        setContentView(R.layout.scrollview)

//        if(intent!=null){
//            username=intent.getStringExtra("userName")
//        }
        username=sharedPreferences.getString("userName","Anonymous") //Anonymous is default
        title=username

        toDark=findViewById(R.id.todarkbtn)
        toLight=findViewById(R.id.tolightbtn)
/*
        boolean isNightMode = sharedPreferences.getBoolean("SwitchState", true);
                if (isNightMode) {
                  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
             }

 */

        toDark.setOnClickListener{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        }

        toLight.setOnClickListener{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }

    }
    override fun onStart() {
        super.onStart()
        println("onstart called")

    }
//    fun tolight(view: View) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        }
//
//        fun todark(view: View) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//        }


}