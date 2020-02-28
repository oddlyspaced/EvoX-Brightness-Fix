package com.oddlyspaced.exb

import android.accessibilityservice.AccessibilityService
import android.app.KeyguardManager
import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class CheckService : AccessibilityService() {

    override fun onServiceConnected() {
        Log.e("CheckService", "Service Started")
        setupServices()
        check()
    }

    private lateinit var keyguardManager: KeyguardManager
    private lateinit var brightnessManager: BrightnessManager
    private var isLocked: Boolean = false
    private var brightnessLocked: Int = 0 //Screen brightness just before locking

    private fun setupServices() {
        keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        brightnessManager = BrightnessManager()
    }

    override fun onInterrupt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun check() {
        Handler().postDelayed({
            if (keyguardManager.isDeviceLocked) {
                if (!isLocked) {
                    isLocked = true
                    brightnessLocked = brightnessManager.getBrightness(applicationContext)
                    brightnessManager.setBrightness(applicationContext, 150)
                    Log.e("CheckService", "Screen Locked with brightness value: $brightnessLocked")
                }
            }
            else {
                if (isLocked) {
                    isLocked = false
                    brightnessManager.setBrightness(applicationContext, brightnessLocked)
                    Log.e("CheckService", "Screen Unlocked, restoring brightness value: $brightnessLocked")
                }
            }
            check()
        }, 200)
    }

}