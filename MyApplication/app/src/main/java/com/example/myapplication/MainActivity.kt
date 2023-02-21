package com.example.myapplication

import android.app.NotificationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.clevertap.android.sdk.CleverTapAPI
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity(){

    val imageURL="https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg"
    val productId=1
    val productName="CleverTap"
    val email="harshraga77@gmail.com"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CleverTapAPI.createNotificationChannel(
            applicationContext,
            "YourChannelId",
            "Your Channel Name",
            "Your Channel Description",
            NotificationManager.IMPORTANCE_MAX,
            true
        )
        val cleverTapAPI = CleverTapAPI.getDefaultInstance(applicationContext)


        btn.setOnClickListener {

            Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()

            val prodViewedAction = HashMap<String, Any>()
            prodViewedAction["Product ID"] = productId
            prodViewedAction["Product Image"] = imageURL
            prodViewedAction["Product Name"] = productName
            prodViewedAction["Email"] = email
            cleverTapAPI?.pushEvent("Product viewed", prodViewedAction)
        }







    }


}