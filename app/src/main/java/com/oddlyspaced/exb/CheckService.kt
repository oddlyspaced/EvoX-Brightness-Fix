package com.oddlyspaced.exb

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class CheckService : AccessibilityService() {
    override fun onServiceConnected() {
        Log.e("CheckService", "Service Started")
    }

    override fun onInterrupt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}