package com.example.paynowdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val amount = findViewById<EditText>(R.id.editTextAmount)
        val currency = findViewById<EditText>(R.id.editTextCurrency)
        val shipmentId = findViewById<EditText>(R.id.editTextShipmentId)
        val accountNumber = findViewById<EditText>(R.id.editTextAccountNumber)

        val generateButton = findViewById<Button>(R.id.buttonGenerate)
        val scanButton = findViewById<Button>(R.id.buttonScan)

//        val amnt = amount.text.toString()


        generateButton.setOnClickListener{

            val genIntent = Intent(this , GeneratedActivity::class.java)


            genIntent.putExtra("currency" , currency.text.toString())
            genIntent.putExtra("amount" , amount.text.toString())
            genIntent.putExtra("shipmentId" , shipmentId.text.toString())
            genIntent.putExtra("accountNumber" , accountNumber.text.toString())

            startActivity(genIntent)
        }


        scanButton.setOnClickListener {

//            val integrator  = IntentIntegrator(this)
//            integrator.setCaptureActivity(CaptureAct::class.java)
//            integrator.setOrientationLocked(false)
//            integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
//            integrator.setPrompt("Scanning...")
//            integrator.initiateScan()

            val scnIntent = Intent(this , ScanActivity::class.java)
            startActivity(scnIntent)

        }








    }

}