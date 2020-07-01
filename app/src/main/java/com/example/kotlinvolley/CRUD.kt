package com.example.kotlinvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_crud.*
import org.json.JSONObject

class CRUD : AppCompatActivity() {
  var id : String = ""
  var name : String = ""
  val url = "https://satriaworld.xyz/api/bean/testcrud/" as String

  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_crud)

      id =  editText.text.toString()
      name = editText2.text.toString()

      try {
        editText.setText(intent.getStringExtra("ID"))
        editText2.setText(intent.getStringExtra("Name"))
      }
      catch (ex : Exception){
        Toast.makeText(getApplicationContext(),""+ex, Toast.LENGTH_SHORT).show()
      }

      val btnSave = findViewById(R.id.savebtn) as Button
      btnSave.setOnClickListener {
        id =  editText.text.toString()
        name = editText2.text.toString()
        val url = url+"/tambah.php"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = object : StringRequest(Method.POST,url,Response.Listener<String>{
            response ->
          try {
            Toast.makeText(getApplicationContext(),"SUCCESS", Toast.LENGTH_SHORT).show()
          }catch (e: Exception){
            e.printStackTrace()
            Toast.makeText(getApplicationContext(),"FAILED", Toast.LENGTH_SHORT).show()
          }

        }, object : Response.ErrorListener{
          override fun onErrorResponse(volleyError: VolleyError) {
            Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show()
          }
        }){
          @Throws(AuthFailureError::class)
          override fun getParams(): Map<String, String> {
            val params = HashMap<String, String>()
            params.put("id", id)
            params.put("name", name)
            return params
          }
        }
        queue.add(stringRequest)
      }

      val btnUpdate = findViewById(R.id.updatebtn) as Button
      btnUpdate.setOnClickListener {
        id =  editText.text.toString()
        name = editText2.text.toString()
        val url = url+"/update.php"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = object : StringRequest(Method.POST,url,Response.Listener<String>{
            response ->
          try {
            Toast.makeText(getApplicationContext(),"SUCCESS", Toast.LENGTH_SHORT).show()
          }catch (e: Exception){
            e.printStackTrace()
            Toast.makeText(getApplicationContext(),"FAILED", Toast.LENGTH_SHORT).show()
          }

        }, object : Response.ErrorListener{
          override fun onErrorResponse(volleyError: VolleyError) {
            Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show()
          }
        }){
          @Throws(AuthFailureError::class)
          override fun getParams(): Map<String, String> {
            val params = HashMap<String, String>()
            params.put("id", id)
            params.put("name", name)
            return params
          }
        }
        queue.add(stringRequest)
      }

      val btnDelete = findViewById(R.id.deletebtn) as Button
      btnDelete.setOnClickListener {
        id =  editText.text.toString()
        name = editText2.text.toString()
        val url = url+"/hapus.php"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = object : StringRequest(Method.POST,url,Response.Listener<String>{
            response ->
          try {
            Toast.makeText(getApplicationContext(),"SUCCESS", Toast.LENGTH_SHORT).show()
          }catch (e: Exception){
            e.printStackTrace()
            Toast.makeText(getApplicationContext(),"FAILED", Toast.LENGTH_SHORT).show()
          }

        }, object : Response.ErrorListener{
          override fun onErrorResponse(volleyError: VolleyError) {
            Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show()
          }
        }){
          @Throws(AuthFailureError::class)
          override fun getParams(): Map<String, String> {
            val params = HashMap<String, String>()
            params.put("id", id)
            params.put("name", name)
            return params
          }
        }
        queue.add(stringRequest)
      }
    }
  }
