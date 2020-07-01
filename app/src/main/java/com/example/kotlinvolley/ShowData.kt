package com.example.kotlinvolley

import android.R.layout.simple_list_item_1
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_data.*
import org.json.JSONException

class ShowData : AppCompatActivity() {
  private var listData = ArrayList<String>()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_show_data)
    loadData()
  }

  private fun loadData() {
    val url ="https://satriaworld.xyz/api/bean/testcrud/user.php"
    val stringRequest =
      JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {
          response ->try {
            val jsonArray =  response.getJSONArray("name")
            for (i in 0 until jsonArray.length()) {
              val employee = jsonArray.getJSONObject(i)
              val id = employee.getString("id")
              val name = employee.getString("name")
              //textView.append("$id, $name\n\n")
              listData.add("$id, $name\n\n")
            }

        lv_user.adapter = ArrayAdapter(this, simple_list_item_1, listData)
          } catch (e: JSONException) {
            e.printStackTrace()
          }
        },
        Response.ErrorListener { error ->
          Toast.makeText(
            applicationContext,
            error.message,
            Toast.LENGTH_SHORT
          ).show()
        })
    val requestQueue = Volley.newRequestQueue(this)
    requestQueue.add(stringRequest)
  }
}