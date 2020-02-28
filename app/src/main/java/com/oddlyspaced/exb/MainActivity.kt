package com.oddlyspaced.exb

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (canWriteSystemSettings()) {
            openAccessibilityMenu()
        }
        else {
            Toast.makeText(applicationContext, "Please re-open app to grant accessibility permission.", Toast.LENGTH_LONG).show()
        }
        finish()
    }

    private fun canWriteSystemSettings(): Boolean {
        if (!Settings.System.canWrite(applicationContext)) {
            val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
            intent.data = Uri.parse("package:com.oddlyspaced.exb")
            startActivity(intent)
            Toast.makeText(applicationContext, "Please grant secure settings permission!", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    private fun openAccessibilityMenu() {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        startActivity(intent)
    }

}
