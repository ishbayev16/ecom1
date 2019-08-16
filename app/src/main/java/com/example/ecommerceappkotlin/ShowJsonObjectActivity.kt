package com.example.ecommerceappkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_json_object.*

class ShowJsonObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_json_object)


        btnSubmit.setOnClickListener {

            val productURL = "https://cmsdeneme2.000webhostapp.com/ecom/present_json.php?id=" + edtProductID.text.toString()

            val requestQ: RequestQueue = Volley.newRequestQueue(this@ShowJsonObjectActivity)

            val jsonOR = JsonObjectRequest(Request.Method.GET, productURL, null,
                Response.Listener { response ->

                txtProductName.text = response.getString("name")
                txtProductPrice.text = response.getInt("price").toString()

            }, Response.ErrorListener {
                error ->

                txtProductName.text = error.message

            })

            requestQ.add(jsonOR)

        }

    }
}
