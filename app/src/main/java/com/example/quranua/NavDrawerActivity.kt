package com.example.quranua

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.quranua.Bookmark.BookmarkFragment
import com.example.quranua.GLobalSearch.GlobalSearchActivity
import com.example.quranua.Loved.LovedListFragment
import com.example.quranua.MainList.ListFragment
import com.example.quranua.Model.Sura
import kotlinx.android.synthetic.main.activity_nav_drawer.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import java.util.ArrayList

open class NavDrawerActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return false
    }

    companion object {
        lateinit var myContext: Context
    }

    var list = ArrayList<Sura>()

    init {
        getData()
    }

    fun getData() {
        CoroutineScope(Dispatchers.Main).launch {
            list = Common.getAllSuras(this@NavDrawerActivity)!!
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        title="Коран"
        myContext = this
        var fragment = ListFragment()
        var baseFragment = BaseFragment().getFragment(fragment, R.id.fragment_content, this)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        quranItem.setOnClickListener {
            openMenuItem(fragment,drawerLayout)
        }
        lovedItem.setOnClickListener {
            var fragment=LovedListFragment()
          openMenuItem(fragment,drawerLayout)
        }
        bookmarksItem.setOnClickListener {
            var fragment=BookmarkFragment()
            openMenuItem(fragment,drawerLayout)
        }
        settingsItem.setOnClickListener {
            var fragment=SettingsFragment()
            openMenuItem(fragment,drawerLayout)

        }
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }



 fun openMenuItem(fragment:Fragment,drawerLayout: DrawerLayout){
     BaseFragment().getFragment(fragment, R.id.fragment_content, this)
     drawerLayout.closeDrawer(GravityCompat.START)
 }

}
