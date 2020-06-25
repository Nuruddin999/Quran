package com.example.quranua.SuraDetails

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quranua.BaseFragment
import com.example.quranua.Common
import com.example.quranua.GLobalSearch.GlobalSearchActivity
import com.example.quranua.Model.Sura
import com.example.quranua.Model.Verse
import com.example.quranua.NavDrawerActivity
import com.example.quranua.R
import kotlinx.android.synthetic.main.app_bar_nav_drawer.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.util.ArrayList
import kotlin.coroutines.CoroutineContext
import kotlin.math.log

open class SuraDetailsFragment : BaseFragment() {

    var suras = ArrayList<Sura>()
    open var adapter: SuraDetailsAdapter? = null
    suspend fun get() = withContext(Dispatchers.IO) {
        return@withContext Common.getAllSuras(context!!)
    }
    suspend fun fetchDocs() {
        // Dispatchers.Main
        suras = get()
        // Dispatchers.Main
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_sura_details, container, false)
        recyclerView = view.findViewById(R.id.sura_details_list)
        layoutManager = LinearLayoutManager(context)
        val searchedittext: EditText = view.findViewById(R.id.search_edittext_details)
        searchedittext.visibility = EditText.GONE
        searchedittext.setOnClickListener {
            var intent = Intent(context, GlobalSearchActivity::class.java)
            startActivity(intent)
        }
        var sura = Sura()
        var suranumber = arguments!!.getInt("suranumb", 0)
        CoroutineScope(Dispatchers.Main).launch {
            fetchDocs()
            sura = suras.get(suranumber-1)
            var pos = arguments!!.getInt("pos")
            adapter = SuraDetailsAdapter(sura.verses!!, context!!, sura)
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.adapter = adapter
            if (pos>0){
                recyclerView!!.scrollToPosition(pos)
            }else {
                recyclerView!!.scrollToPosition(1)
            }

        }
        return view
    }




}