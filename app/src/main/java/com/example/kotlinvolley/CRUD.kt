package com.example.kotlinvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_crud.*
import org.json.JSONException
import org.json.JSONObject

class CRUD : AppCompatActivity() {
  var id : String = ""
  var name : String = ""
  var hasil : String = ""
  var jsondata : String = ""
  var data : String = ""
  var jObject = JSONObject()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_crud)

    id =  editText.text.toString()
    name = editText2.text.toString()//textView2.toString() //findViewById<EditText>( R.id.editText2).toString()

    try {
      editText.setText(intent.getStringExtra("ID"))
      editText2.setText(intent.getStringExtra("Name"))
      Toast.makeText(getApplicationContext(),""+intent.getStringExtra("Name"), Toast.LENGTH_SHORT).show()
    }
    catch (ex : Exception){
      Toast.makeText(getApplicationContext(),""+ex, Toast.LENGTH_SHORT).show()
    }

  }

  public fun btnSimpan (v : View)
  {
    id =  editText.text.toString()
    name = editText2.text.toString()
    val url = "http://10.0.2.2/maps/tambah.php"
    textView.text = ""
    val queue = Volley.newRequestQueue(this)
    val stringRequest = object : StringRequest(Method.POST,url,Response.Listener<String>{
        response ->
      try {
        textView3.text = response
      }catch (e: Exception){
        e.printStackTrace()
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