package com.example.ecommerceappkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_all_jsonobject.*

class ShowAllJSONObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_jsonobject)

        txtAllClick.setOnClickListener {
            val URL = "https://cmsdeneme2.000webhostapp.com/ecom/present_json_array.php"
            var allProducs: String = "";
            val requestQ: RequestQueue = Volley.newRequestQueue(this@ShowAllJSONObjectActivity)

            val jsonAR = JsonArrayRequest(Request.Method.GET, URL, null, Response.Listener {
                    response ->

                for(productIndex in 0.until(response.length())){
                    allProducs += response.getJSONObject(productIndex).getString("name") +
                            " - " +response.getJSONObject(productIndex).getInt("price").toString()+"\n\n"
                }

                txtAllProducts.text = allProducs
            }, Response.ErrorListener {
                error -> txtAllProducts.text = error.message + "Errorr"
            })

            requestQ.add(jsonAR)
        }
    }
}
