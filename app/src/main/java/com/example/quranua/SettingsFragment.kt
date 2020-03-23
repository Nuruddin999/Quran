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
        var view = inflater.inflate(R.layout.settings_fragment_layout, container, false)
        var seekbar: SeekBar = view.findViewById(R.id.settings_textsizeseekbar)
        seekbar.progressDrawable.setColorFilter(
            resources.getColor(R.color.colorPrimary),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
        var textSizeDsiplay: TextView = view.findViewById(R.id.settings_textsizedisplay)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekbar.min = 10
        }
        seekbar.max = 30
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textSizeDsiplay.textSize = p1.toFloat()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        var settings_arabictext: Switch = view.findViewById(R.id.settings_arabictext)
        settings_arabictext.setOnCheckedChangeListener { compoundButton, b ->
            run {

                val sharedPref = activity?.getSharedPreferences("settings",Context.MODE_PRIVATE)
                    ?: return@setOnCheckedChangeListener
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