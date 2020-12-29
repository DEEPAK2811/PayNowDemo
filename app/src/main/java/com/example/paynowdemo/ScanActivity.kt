package com.example.paynowdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

const val TAG: String = "TAG"

var amnt : String = ""
var curr : String = ""
var sID : String = ""
var acn : String = ""

class ScanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        scanQRCode()


//        val amountTV = findViewById<TextView>(R.id.tVamount)
//        val currTV = findViewById<TextView>(R.id.tVcurrency)
//        var sIDs = findViewById<TextView>(R.id.tVsID)
//        var acn = findViewById<TextView>(R.id.tVACn)
//
//        amountTV.text = "Amount : " + amnt
//        currTV.text = "Currency : " + curr
//        sIDs.text = "Shipment ID : " + sID
//        acn.text = "BankAccountNumber : " + acn






//        scanQRCode()
    }

    private fun scanQRCode(){
        val integrator = IntentIntegrator(this).apply {
            captureActivity = CaptureAct::class.java
            setOrientationLocked(false)
            setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
            setPrompt("Scanning Code")
        }
        integrator.initiateScan()
    }

    // Get the results:
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            else {

//                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()

                val rcvdata = result.contents.split(',').toTypedArray()
                curr = rcvdata[0]
                amnt = rcvdata[1]
                sID = rcvdata[2]
                acn = rcvdata[3]

                this.findViewById<TextView>(R.id.tVcurrency).text = "Currency : " + rcvdata[0]
                this.findViewById<TextView>(R.id.tVamount).text = "Amount : " + rcvdata[1]
                this.findViewById<TextView>(R.id.tVsID).text = "Shipment ID : " + rcvdata[2]
                this.findViewById<TextView>(R.id.tVACn).text = "BankAccountNumber : " +rcvdata[3]









            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}