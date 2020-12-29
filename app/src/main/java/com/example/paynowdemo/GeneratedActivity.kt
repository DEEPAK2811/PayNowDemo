package com.example.paynowdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder

class GeneratedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generated)

        val values = intent

        val amount = values.getStringExtra("amount")
        val currency = values.getStringExtra("currency")
        val accountNumber = values.getStringExtra("accountNumber")
        val shipmentId = values.getStringExtra("shipmentId")


        val tv1 = findViewById<TextView>(R.id.tv1)
        val imgV = findViewById<ImageView>(R.id.imgGenQR)

        val text1 = currency + "," + amount + "," + shipmentId + "," + accountNumber

//        tv1.text = text1

        val writer  = MultiFormatWriter()

        try {
            val matrix: BitMatrix = writer.encode(text1, BarcodeFormat.QR_CODE, 350, 350)
            val encoder = BarcodeEncoder()
            val bitmap = encoder.createBitmap(matrix)

            imgV.setImageBitmap(bitmap)

        }catch (e : WriterException){
            e.printStackTrace()
        }







    }

}