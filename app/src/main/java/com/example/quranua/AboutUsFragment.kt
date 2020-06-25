package com.example.quranua

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.LayerDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.fragment_about_us.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.ColorDrawable


class AboutUsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_about_us, container, false)
        var aboutustext: TextView = view.findViewById(R.id.aboutustext)
        var aboutush1: TextView = view.findViewById(R.id.aboutush1)
        var aboutusourweb: TextView = view.findViewById(R.id.aboutusweb)
        var webname: TextView = view.findViewById(R.id.aboutuswebname)
        var faceb: TextView = view.findViewById(R.id.aboutusfacebook)
        var facebname: TextView = view.findViewById(R.id.aboutusfacebookname)
        var yout: TextView = view.findViewById(R.id.aboutusyoutube)
        var youtname: TextView = view.findViewById(R.id.aboutusyoutubename)
        var insta: TextView = view.findViewById(R.id.aboutusinsta)
        var instaname: TextView = view.findViewById(R.id.aboutusinstaname)
        var latobold: Typeface = ResourcesCompat.getFont(context!!, R.font.latobold)!!;
        var lato: Typeface = ResourcesCompat.getFont(context!!, R.font.latolight)!!;
        var weblink=webname.text
        var faceblink="https://www.facebook.com/amulifeislam/"
        var instalink="https://www.instagram.com/amulifeislam/"
        var youtubelink="https://www.youtube.com/amulifeislam/"
        aboutustext.typeface = lato
        aboutush1.typeface = latobold
        aboutusourweb.typeface = latobold
        webname.typeface = lato
        faceb.typeface = latobold
        facebname.typeface = lato
        yout.typeface = latobold
        youtname.typeface = lato
        insta.typeface=latobold
        instaname.typeface=lato
        webname.setOnClickListener {
            openWebPage("https://amu.org.ua/")
        }
        facebname.setOnClickListener {
            openWebPage(faceblink)
        }
        youtname.setOnClickListener {
            openWebPage(youtubelink)
        }
        instaname.setOnClickListener {
            openWebPage(instalink)
        }
        return view
    }
    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)

    }

}
