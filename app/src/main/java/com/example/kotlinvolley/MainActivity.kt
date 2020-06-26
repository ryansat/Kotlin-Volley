package com.example.kotlinvolley

import android.os.Bundle
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
        textView = findViewById(R.id.textViewResult)
        val button: Button = findViewById(R.id.btnParse)
        requestQueue = Volley.newRequestQueue(this)
        button.setOnClickListener {
            jsonParse()
        }
    }
    private fun jsonParse() {
        val url ="http://10.0.2.2/maps/tampil.php"
        val request = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {
            response ->try {
            val jsonArray = response.getJSONArray("user")
            for (i in 0 until jsonArray.length()) {
                val employee = jsonArray.getJSONObject(i)
                val id = employee.getString("id")
                val name = employee.getString("name")
                textView.append("$id, $name\n\n")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, Response.ErrorListener {
            error -> error.printStackTrace()
        })
        requestQueue?.add(request)
    }
}