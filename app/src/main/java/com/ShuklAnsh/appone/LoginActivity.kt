package com.ShuklAnsh.appone

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Size
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

/*class LoginActivity : AppCompatActivity() === means class LoginActivity is implementing interface AppCompatActivity. so to
implement the interface "OnClickListener" of class View, we use the following code
 -- a class can implement multiple interfaces.
 -- when we implement an interface, we need to implement all its member functions as well. using override kw
 -- OnClick() is a method inside */
class LoginActivity : AppCompatActivity()//, View.OnClickListener
{

//    override fun onClick(p0: View?) {
//        //  long way. shorter way=> by using lambda representation
//        //this function is where we can add tasks to be done when the submitBtn is pressed
//        //adding toast : this@activityname = context, then text to be displayed for toast, then the toast length.... then .show() the whole thing
//
//        Toast.makeText(
//            this@LoginActivity,
//            "Submitted the information :D",
//            Toast.LENGTH_LONG).show()
//    }

    //declaring variables for xml views
    lateinit var mobNo: EditText
    lateinit var passwordtext: EditText
    lateinit var submitBtn: Button
    lateinit var forgotPassText: TextView
    lateinit var registerText: TextView


    lateinit var sharedPreferences: SharedPreferences //declaring sharedprefernce variable


    //pairs: ezio=>8520 , maria=>0258, giovanni=>0258, federico=>123
    val validpasswords = arrayOf("8520", "0258", "123")
    val validUsers = arrayOf("ezio", "maria", "giovanni", "federico", "")
    var newactname: String? = "anonymous"
//    val validMobno = "ezio"
//    val validPass = "8520"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false) //here=> false is the default value for first time login. if getboolean is true then automatically go to new act.
        setContentView(R.layout.activity_login) //this will make the current activity as loginscreen as isloggedin is false and user needs to login now.
        if (isLoggedIn){
            val intent=Intent(this@LoginActivity,ProfilePage::class.java)
            startActivity(intent)
            finish()
        }
        supportActionBar?.hide() //hide toolbar

          //creating object of sharedpreference class inside oncreate()

        title = "Login Page" //name on toolbar

        //connecting field variables to xml views
        mobNo = findViewById(R.id.mobno)
        passwordtext = findViewById(R.id.passwordText)
        submitBtn = findViewById(R.id.submitbtn)
        forgotPassText = findViewById(R.id.frgtpass)
        registerText = findViewById(R.id.register)


        //submitBtn.setOnClickListener(this)

        //VALID VALS WILL BE CHECKED IF BTN PRESSED.
        submitBtn.setOnClickListener {
            //LAMBDA REPRESENTATION OF MAKING TOAST
            //extracting info from edittext fields when btn is pressed
            val enteredMobNo = mobNo.text.toString()
            val enteredPass = passwordtext.text.toString()


            //first activity is source, second is destination. the respective xml are in their setContentView
            val intent = Intent(this@LoginActivity, ProfilePage::class.java)


            if (enteredMobNo == validUsers[0] && enteredPass == validpasswords[0]) {
                //intent passed as argument to startActivity() to open dest act from source act

                newactname = "ezio"
                saveSharedPreferenceBoolean(newactname!!)
                //intent.putExtra("userName", newactname)
                startActivity(intent)
                //Passing the name of user based on login to the next activity using intent.


                welcomeToast()
            } else if (enteredMobNo == validUsers[1] && enteredPass == validpasswords[1]) {

                //intent passed as argument to startActivity() to open dest act from source act
                newactname = "maria"
                saveSharedPreferenceBoolean(newactname!!)
                //Passing the name of user based on login to the next activity using intent.
                //intent.putExtra("userName", newactname)
                startActivity(intent)

                welcomeToast()
            } else if (enteredMobNo == validUsers[2] && enteredPass == validpasswords[1]) {

                //intent passed as argument to startActivity() to open dest act from source act
                newactname = "giovanni"
                saveSharedPreferenceBoolean(newactname!!)
                //Passing the name of user based on login to the next activity using intent.
                //intent.putExtra("userName", newactname)
                startActivity(intent)
                welcomeToast()
            } else if (enteredMobNo == validUsers[3] && enteredPass == validpasswords[2]) {

                //intent passed as argument to startActivity() to open dest act from source act
                newactname = "federico"
                saveSharedPreferenceBoolean(newactname!!)
                //Passing the name of user based on login to the next activity using intent.
                //intent.putExtra("userName", newactname)
                startActivity(intent)
                welcomeToast()


            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Incorrect mobile number or password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
        //so that user info is not present when going back to login screen
    }

    fun welcomeToast() {
        Toast.makeText(
            this@LoginActivity,
            "Welcome " + newactname,
            Toast.LENGTH_LONG
        ).show()
    }


    //function to save login boolean value as true when user is logged in
    fun saveSharedPreferenceBoolean(userName:String) {

        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()

        sharedPreferences.edit().putString("userName", userName).apply()

    }
}