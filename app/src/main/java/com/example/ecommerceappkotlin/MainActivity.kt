package com.example.ecommerceappkotlin

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var sharedP: SharedPreferences? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            sharedP = getSharedPreferences("addData", Context.MODE_PRIVATE)
            //editor job to write data to sharedPreferences
            var myEditer = sharedP?.edit()
            myEditer?.putString("product_name",edtProduct.text.toString())
            myEditer?.commit()

        }

        btnGetProduct.setOnClickListener {
            //second argument is default arg
            txtGetProduct.text = sharedP?.getString("product_name","")
        }



    }
}
