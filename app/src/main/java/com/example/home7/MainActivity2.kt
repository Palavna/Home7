package com.example.home7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val login = findViewById<EditText>(R.id.login)
        val famil = findViewById<EditText>(R.id.famil)
        val sohran = findViewById<Button>(R.id.sohran)
        sohran.setOnClickListener {
            val intent = Intent()
            intent.putExtra(MainActivity.LOGIN, login.text.toString())
            intent.putExtra(MainActivity.FAMIL, famil.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}