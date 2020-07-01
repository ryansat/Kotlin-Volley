package com.example.kotlinvolley

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException


class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private var requestQueue: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        val button = findViewById(R.id.btnParse) as Button
        val crudData = findViewById(R.id.crudData) as Button
        requestQueue = Volley.newRequestQueue(this)

        button.setOnClickListener {
            val intent = Intent(this, ShowData::class.java)
            startActivity(intent)
        }

        crudData.setOnClickListener {
            val intent = Intent(this, CRUD::class.java)
            startActivity(intent)
        }
    }

}