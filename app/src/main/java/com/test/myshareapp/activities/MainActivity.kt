package com.test.myshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.test.myshareapp.R
import com.test.myshareapp.utils.Constants
import com.test.myshareapp.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSendMessage.setOnClickListener {
            Log.i(TAG, "Send message button clicked")
            val message: String = etMessage.text.toString()
            showToast("Send message button clicked with text : $message")

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MESSAGE_KEY, message)
            startActivity(intent)
        }

        btnShareMessage.setOnClickListener {
            showToast("Share message button clicked")

            val messageToShare: String = etMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, messageToShare)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, messageToShare))
        }

        btnRecyclerView.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}