package com.example.ecommerceappkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_download_image.*

class DownloadImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_image)

        btnDownloadImage.setOnClickListener {

            val imageURL = "https://cmsdeneme2.000webhostapp.com/cms/images/image_1.jpg"

            Picasso.get().load("https://cmsdeneme2.000webhostapp.com/cms/images/image_1.jpg").into(imgDownloadedImage)



        }

    }
}
