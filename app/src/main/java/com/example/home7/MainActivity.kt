package com.example.home7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var email: TextView
    private lateinit var name: TextView

    private val emailNameResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                email.text = it.data?.extras?.getString(LOGIN)
                name.text = it.data?.extras?.getString(FAMIL)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.email)
        name = findViewById(R.id.name)
        val gde = findViewById<Button>(R.id.batn)
        gde.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
//            startActivityForResult(intent, EMAIL_NAME_REQUEST_CODE)
            emailNameResult.launch(intent)
        }
    }

    //    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == EMAIL_NAME_REQUEST_CODE){
//            if (resultCode == RESULT_OK){
//                email.text = data?.extras?.getString(LOGIN)
//                name.text = data?.extras?.getString(FAMIL)
//            }
//        }
    //   }
    companion object {
        const val EMAIL_NAME_REQUEST_CODE = 555
        const val LOGIN = "Login"
        const val FAMIL = "Famil"
    }
}