package com.hamin.security

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Button
import android.widget.TextView
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val button = Button(this)
        button.text = "Start HAMIN Scan"

        val textView = TextView(this)
        textView.text = "Press button to scan apps"

        button.setOnClickListener {
            val apps = getApps()
            textView.text = apps.joinToString("\n\n")
        }

        layout.addView(button)
        layout.addView(textView)

        setContentView(layout)
    }

    private fun getApps(): List<String> {
        val pm: PackageManager = packageManager
        val apps = pm.getInstalledApplications(0)

        return apps.map {
            val name = pm.getApplicationLabel(it).toString()
            val pkg = it.packageName
            "$name\n$pkg"
        }
    }
}
