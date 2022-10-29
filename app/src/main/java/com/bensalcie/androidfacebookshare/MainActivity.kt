package com.bensalcie.androidfacebookshare

import android.app.AlertDialog
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.share.model.ShareLinkContent
import com.facebook.share.widget.ShareDialog
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {
    var callbackManager: CallbackManager? = null
    var shareDialog: ShareDialog? = null
    private lateinit var shareButton:MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callbackManager = CallbackManager.Factory.create();
        shareButton= findViewById(R.id.btnShare)
        shareDialog =  ShareDialog(this)
        // this part is optional
        shareButton.setOnClickListener {
            shareLinkOnFaceBook(link = "https://bensalcie.payherokenya.com")
        }








    }
    private fun shareLinkOnFaceBook( link:String){

        if (ShareDialog.canShow(ShareLinkContent::class.java)) {
            val linkContent: ShareLinkContent = ShareLinkContent.Builder()
                .setContentUrl(Uri.parse(link))
                .build()
            shareDialog!!.show(linkContent)
        }
    }

}