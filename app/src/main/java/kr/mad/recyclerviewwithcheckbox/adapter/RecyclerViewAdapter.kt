package kr.mad.recyclerviewwithcheckbox.adapter

import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.graphics.Paint
import android.os.Build
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import kr.mad.recyclerviewwithcheckbox.R
import kr.mad.recyclerviewwithcheckbox.data.RecyclerViewData


class RecyclerViewAdapter(private val context: Context)  : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var dataSet = mutableListOf<RecyclerViewData>()

    private val chkBoxStatus = SparseArray<String>()
    private val favoriteChkBoxStatus = SparseArray<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(dataSet[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val chkBox: CheckBox = itemView.findViewById(R.id.chkBox)
        private val viewText: TextView = itemView.findViewById(R.id.viewText)
        private val favoriteChkBox: CheckBox = itemView.findViewById(R.id.favoriteChkBox)

        @RequiresApi(Build.VERSION_CODES.S)
        fun bind(item: RecyclerViewData) {
            viewText.text = item.viewText

            viewText.setOnLongClickListener{
                Toast.makeText(context, "Long click detected", Toast.LENGTH_SHORT).show()
                true
            }

            if(chkBoxStatus[adapterPosition] == null)
            {
                chkBoxStatus[adapterPosition] = item.chkBox.toString()
            }

            chkBox.isChecked = chkBoxStatus[adapterPosition].equals("true")

            if(chkBox.isChecked)
                viewText.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            else
                viewText.paintFlags = 0

            chkBox.setOnClickListener(null)
            chkBox.setOnClickListener() {
                chkBoxStatus.put(adapterPosition, chkBox.isChecked.toString())

                if(chkBox.isChecked)
                    viewText.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                else
                    viewText.paintFlags = 0
            }

            if(favoriteChkBoxStatus[adapterPosition] == null)
            {
                favoriteChkBoxStatus[adapterPosition] = item.chkBox.toString()
            }

            favoriteChkBox.isChecked = favoriteChkBoxStatus[adapterPosition].equals("true")

            favoriteChkBox.setOnClickListener(null)
            favoriteChkBox.setOnClickListener() {
                favoriteChkBoxStatus.put(adapterPosition, favoriteChkBox.isChecked.toString())
            }

        }
    }
}