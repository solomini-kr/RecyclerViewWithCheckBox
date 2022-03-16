package kr.mad.recyclerviewwithcheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.mad.recyclerviewwithcheckbox.adapter.RecyclerViewAdapter
import kr.mad.recyclerviewwithcheckbox.data.RecyclerViewData

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    val recyclerViewData = mutableListOf<RecyclerViewData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewAdapter = RecyclerViewAdapter(this)
        recyclerView.adapter = recyclerViewAdapter

        recyclerViewData.apply {
            add(RecyclerViewData(chkBox = true, viewText = "할일들", favoriteChkBox = true))
            add(RecyclerViewData(chkBox = false, viewText = "할일들2", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = true, viewText = "할일들3", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = false, viewText = "할일들4", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = true, viewText = "할일들5", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = false, viewText = "할일들6", favoriteChkBox = true))
            add(RecyclerViewData(chkBox = false, viewText = "할일들7", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = false, viewText = "할일들8", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = false, viewText = "할일들9", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = false, viewText = "할일들10", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = true, viewText = "할일들11", favoriteChkBox = true))
            add(RecyclerViewData(chkBox = false, viewText = "할일들12", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = true, viewText = "할일들13", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = false, viewText = "할일들14", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = true, viewText = "할일들15", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = false, viewText = "할일들16", favoriteChkBox = true))
            add(RecyclerViewData(chkBox = false, viewText = "할일들17", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = false, viewText = "할일들18", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = false, viewText = "할일들19", favoriteChkBox = false))
            add(RecyclerViewData(chkBox = false, viewText = "할일들20", favoriteChkBox = false))

            recyclerViewAdapter.dataSet = recyclerViewData
            recyclerViewAdapter.notifyDataSetChanged()

        }

    }
}