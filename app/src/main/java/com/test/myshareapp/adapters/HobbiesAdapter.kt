package com.test.myshareapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.test.myshareapp.R
import com.test.myshareapp.models.HobbiesModel
import com.test.myshareapp.utils.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbiesModel: List<HobbiesModel>) : RecyclerView.Adapter<HobbiesAdapter.HobbiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return HobbiesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbiesModel.size
    }

    override fun onBindViewHolder(holder: HobbiesViewHolder, position: Int) {
        val hobbyModel = hobbiesModel[position]
        holder.setData(hobbyModel, position)
    }

    inner class HobbiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var selectedHobby: HobbiesModel? = null
        var selectedPosition: Int = 0

        init {
            itemView.setOnClickListener {
                selectedHobby?.let {
                    context.showToast(selectedHobby!!.hobbiesTitle + " clicked !", Toast.LENGTH_LONG)
                }
            }

            itemView.ivShare.setOnClickListener {
                selectedHobby?.let {
                    val messageToShare: String = "My hobby is : " + selectedHobby!!.hobbiesTitle

                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, messageToShare)
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent, "Please select app: "))
                }
            }
        }

        fun setData(hobbyModel: HobbiesModel?, position: Int) {
            hobbyModel?.let {
                itemView.tvHobbyTitle.text = hobbyModel!!.hobbiesTitle
            }

            this.selectedHobby = hobbyModel
            this.selectedPosition = position
        }
    }
}