package com.example.my_first_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun View.displayToast()
    {
        Toast.makeText(getApplicationContext(),"Wait a minute...",Toast.LENGTH_SHORT).show()
    }
}