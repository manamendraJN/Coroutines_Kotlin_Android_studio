package com.example.coroutines_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.button)
        val textView:TextView = findViewById(R.id.textView)

        CoroutineScope(Dispatchers.Main).launch{

            counter(textView)
        }

        button.setOnClickListener{
            Toast.makeText(this,"Hello,World",Toast.LENGTH_LONG).show()
            runBlocking {
                delay(3000)
            }
        }

    }

    private suspend fun counter(view:TextView){
        var x = 0
        while(true){
            delay(1000)
            view.text = x.toString()
            x ++

    }



}}