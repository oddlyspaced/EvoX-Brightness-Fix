package com.oddlyspaced.exb

import android.content.Context
import android.provider.Settings


class BrightnessManager {
    fun getBrightness(ctx: Context): Int = Settings.System.getInt(ctx.contentResolver, Settings.System.SCREEN_BRIGHTNESS, 0)
    fun setBrightness(ctx: Context, value: Int): Boolean = Settings.System.putInt(ctx.contentResolver, Settings.System.SCREEN_BRIGHTNESS, value)
}