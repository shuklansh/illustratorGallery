package com.ShuklAnsh.appone

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class ProfilePage : AppCompatActivity() {


    lateinit var profileimag:ImageView
    lateinit var profilename:TextView
    lateinit var toprojbtn:Button
    var username:String?=""
    lateinit var sharedPreferences: SharedPreferences

    lateinit var logoutbtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        setContentView(R.layout.activity_profile_page)
        profileimag=findViewById(R.id.userImage)
        profilename=findViewById(R.id.userName)
        toprojbtn=findViewById(R.id.gotoprojsbtn)
        logoutbtn=findViewById(R.id.logoutbtn)

//        if(intent!=null){
//            username=intent.getStringExtra("userName")
//        }

        username=sharedPreferences.getString("userName","Anonymous")
        title=username


        loadprof(username)


        toprojbtn.setOnClickListener{
            val intent=Intent(this@ProfilePage,MainActivity::class.java)
            intent.putExtra("userName",username)
            startActivity(intent)
        }

        logoutbtn.setOnClickListener{
            sharedPreferences.edit().putBoolean("isLoggedIn",false).apply()
            val intent=Intent(this@ProfilePage,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }




    }
    private fun loadprof(user: String?){
        if(user=="ezio"){
            profilename.text = "Ezio Auditore Da Firenze"
            profileimag.setImageResource(R.drawable.ezio)
        }

        else if(user=="maria"){
            profilename.text = "Maria Auditore"
            profileimag.setImageResource(R.drawable.maria)
        }

        else if(user=="giovanni"){
            profilename.text = "Giovanni Auditore"
            profileimag.setImageResource(R.drawable.giovanni)
        }

        else if(user=="federico"){
            profilename.text = "Federico Auditore"
            profileimag.setImageResource(R.drawable.fede)
        }

        else if(user==""){
            profilename.text = "Anonymous"
            profileimag.setImageResource(R.drawable.anonymous)
        }



    }



}