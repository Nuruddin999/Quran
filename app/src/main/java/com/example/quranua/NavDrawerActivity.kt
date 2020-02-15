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
import com.example.quranua.Bookmark.BookmarkFragment
import com.example.quranua.GLobalSearch.GlobalSearchActivity
import com.example.quranua.Loved.LovedListFragment
import com.example.quranua.MainList.ListFragment
import com.example.quranua.Model.Sura
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import java.util.ArrayList

open class NavDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
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
        myContext = this
        var fragment = ListFragment()

        var baseFragment = BaseFragment().getFragment(fragment, R.id.fragment_content, this)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val searchedittext: EditText = findViewById(R.id.search_edittext)
        searchedittext.visibility = EditText.VISIBLE
        var fragmentzone: LinearLayout = findViewById(R.id.fragmentzone)
        searchedittext.setOnClickListener {
            var intent = Intent(this, GlobalSearchActivity::class.java)
            startActivity(intent)
        }
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    /*   override fun onCreateOptionsMenu(menu: Menu): Boolean {
           // Inflate the menu; this adds items to the action bar if it is present.
           menuInflater.inflate(R.menu.nav_drawer, menu)

           val searchItem = menu.findItem(R.id.action_search)
           // Optional: if you want to expand SearchView from icon to edittext view
           searchItem.expandActionView()

           val searchView = searchItem.actionView as SearchView

           return true
       }*/

    /* override fun onOptionsItemSelected(item: MenuItem): Boolean {
         // Handle action bar item clicks here. The action bar will
         // automatically handle clicks on the Home/Up button, so long
         // as you specify a parent activity in AndroidManifest.xml.
         return when (item.itemId) {
             R.id.action_search -> true
             else -> super.onOptionsItemSelected(item)
         }
     }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                var fragment = ListFragment()
                var baseFragment = BaseFragment().getFragment(fragment, R.id.fragment_content, this)
            }
            R.id.nav_gallery -> {
                var bookmarkFragment = BookmarkFragment()
                var baseFragment = BaseFragment().getFragment(bookmarkFragment, R.id.fragment_content, this)
            }
            R.id.nav_slideshow -> {
                var fragment = LovedListFragment()
                var baseFragment = BaseFragment().getFragment(fragment, R.id.fragment_content, this)
            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}
