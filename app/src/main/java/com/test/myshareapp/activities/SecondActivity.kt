package com.test.myshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.myshareapp.R
import com.test.myshareapp.utils.Constants
import com.test.myshareapp.utils.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Safe Call ?.
        // Safe Call with let  ?.let { }

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val received_msg = bundle.getString(Constants.USER_MESSAGE_KEY)

            showToast(received_msg.toString())
            tvMessageReceived.text = received_msg
        }
    }
}