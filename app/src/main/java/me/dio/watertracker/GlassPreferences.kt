package me.dio.watertracker

import android.content.Context
import androidx.core.content.edit
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class GlassPreferences(private val context: Context) {

    companion object {
        const val PREFS_NAME = "me.dio.watertracker.preferences"
        const val PREF_PREFIX = "key_"
    }

    private val sdf = SimpleDateFormat("ddMMyyyy", Locale.US)

    fun save(value: Int) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit {
            putInt(PREF_PREFIX + sdf.format(Date()), value)
        }
    }

    fun fetch() = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getInt(PREF_PREFIX + sdf.format(Date()), 0) // função que retorna um inteiro

}