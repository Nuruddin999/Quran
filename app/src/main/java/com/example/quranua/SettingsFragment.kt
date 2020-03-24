package com.example.quranua

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quranua.MainList.MainListAdapter
import com.example.quranua.Model.Verse
import kotlinx.android.synthetic.main.settings_fragment_layout.*

class SettingsFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Вигляд"
        val sharedPref = activity?.getSharedPreferences("settings", Context.MODE_PRIVATE)
        var view = inflater.inflate(R.layout.settings_fragment_layout, container, false)
        var seekbar: SeekBar = view.findViewById(R.id.settings_textsizeseekbar)
        seekbar.progressDrawable.setColorFilter(
            resources.getColor(R.color.colorPrimary),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
        var textSizeDsiplay: TextView = view.findViewById(R.id.settings_textsizedisplay)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekbar.min = 1
        }
        seekbar.max = 30
        seekbar.progress = 12
        if (sharedPref!!.contains("Textsize")) {
            seekbar.progress = sharedPref.getInt("Textsize", 12)
        }
        textSizeDsiplay.textSize = seekbar.progress.toFloat()
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textSizeDsiplay.textSize = p1.toFloat()

                with(sharedPref.edit()) {
                    putInt("Textsize", p1)
                    commit()
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        var settings_arabictext: Switch = view.findViewById(R.id.settings_arabictext)
        if (sharedPref!!.contains("Arabictext")) {
            settings_arabictext.isChecked = true
        }
        settings_arabictext.setOnCheckedChangeListener { compoundButton, b ->
            run {
                with(sharedPref.edit()) {
                    if (b) {
                        putBoolean("Arabictext", true)
                    } else {
                        remove("Arabictext")
                    }
                    commit()

                }


            }
        }
        return view

    }
}