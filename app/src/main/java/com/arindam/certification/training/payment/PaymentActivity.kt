package com.arindam.certification.training.payment

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.paytm.pgsdk.PaytmOrder
import com.paytm.pgsdk.PaytmPGService


/**
 * Created by Arindam Karmakar on 5/7/19.
 */

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data


        initPaytm()
    }

    private fun initPaytm() {

        // SMS Permission Check
        if (ContextCompat.checkSelfPermission(this@PaymentActivity, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@PaymentActivity, arrayOf(Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS), 101)
        }


        // For Staging Environment
        val service = PaytmPGService.getStagingService()
        // For Production Environment
        //val service = PaytmPGService.getProductionService()


        val paramMap = HashMap<String, String>()
        paramMap["MID"] = "rxazcv89315285244163"
        // Key in your staging and production MID available in your dashboard
        paramMap["ORDER_ID"] = "order1"
        paramMap["CUST_ID"] = "cust123"
        paramMap["MOBILE_NO"] = "7777777777"
        paramMap["EMAIL"] = "username@emailprovider.com"
        paramMap["CHANNEL_ID"] = "WAP"
        paramMap["TXN_AMOUNT"] = "100.12"
        paramMap["WEBSITE"] = "WEBSTAGING"
        // This is the staging value. Production value is available in your dashboard
        paramMap["INDUSTRY_TYPE_ID"] = "Retail"
        // This is the staging value. Production value is available in your dashboard
        paramMap["CALLBACK_URL"] = "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=order1"
        paramMap["CHECKSUMHASH"] = "w2QDRMgp1234567JEAPCIOmNgQvsi+BhpqijfM9KvFfRiPmGSt3Ddzw+oTaGCLneJwxFFq5mqTMwJXdQE2EzK4px2xruDqKZjHupz9yXev4="

        // Order Order
        val order = PaytmOrder(paramMap)

        // Initiate Payment
        service.initialize(order, null)
    }
}