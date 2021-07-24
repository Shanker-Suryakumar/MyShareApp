package com.test.myshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.myshareapp.R
import com.test.myshareapp.adapters.HobbiesAdapter
import com.test.myshareapp.models.HobbiesModel
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {

    companion object {
        val TAG: String = HobbiesActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvHobbiesList.layoutManager = layoutManager

        val hobbiesAdapter = HobbiesAdapter(this, HobbiesModel.Supplier.hobbiesList)
        rvHobbiesList.adapter = hobbiesAdapter
    }
}
