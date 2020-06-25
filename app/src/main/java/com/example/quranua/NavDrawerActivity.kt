package com.example.quranua

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.quranua.Bookmark.BookmarkFragment
import com.example.quranua.GLobalSearch.GlobalSearchActivity
import com.example.quranua.Loved.LovedListFragment
import com.example.quranua.MainList.ListFragment
import com.example.quranua.Model.Sura
import kotlinx.android.synthetic.main.activity_nav_drawer.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import java.util.ArrayList
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.view.Menu
import android.widget.*


open class NavDrawerActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {
    private var toggle: ActionBarDrawerToggle? = null
    private var drawerLayout: DrawerLayout? = null
    private var navView: NavigationView? = null
    private var fragmentManager: FragmentManager? = null
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
        var actnbtn: ImageView = toolbar.findViewById(R.id.actnbtn)
        var fragtitle:TextView=toolbar.findViewById(R.id.fragmenttitle)
        fragtitle.text="Коран"
        actnbtn.visibility = ImageView.GONE
        var actionBar = supportActionBar
        actionBar!!.setHomeButtonEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        myContext = this
        fragmentManager = supportFragmentManager
        var fragment = ListFragment()
        changeFragment(fragment, R.id.fragment_content, false)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        toggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }
        }
        drawerLayout!!.addDrawerListener(toggle!!)


        navView!!.setNavigationItemSelectedListener(this)
        quranItem.setOnClickListener {
            openMenuItem(fragment, drawerLayout!!)
        }
        lovedItem.setOnClickListener {
           LovedListFragment().also {
                openMenuItem(it, drawerLayout!!)
            }
        }
        bookmarksItem.setOnClickListener {
            BookmarkFragment().also {
                openMenuItem(it, drawerLayout!!)
            }
        }
        settingsItem.setOnClickListener {
           SettingsFragment().also {
                openMenuItem(it, drawerLayout!!)
            }
        }
        mailItem.setOnClickListener {
            AboutUsFragment().also {
                openMenuItem(it,drawerLayout!!)
            }
        }

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        if (toggle !== null) {
            toggle!!.syncState()
        }
    }


    fun openMenuItem(fragment: Fragment, drawerLayout: DrawerLayout) {
        changeFragment(fragment, R.id.fragment_content, true)
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    fun changeFragment(fragment: Fragment, view: Int, addtobackstack: Boolean) {
        var fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(view, fragment)
        if (addtobackstack) fragmentTransaction.addToBackStack("my")
        fragmentTransaction.commit()
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {
            android.R.id.home -> {
                //  onBackPressed()
                Log.d("btn", "vf")
                Toast.makeText(this, "DSFS", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }



}
