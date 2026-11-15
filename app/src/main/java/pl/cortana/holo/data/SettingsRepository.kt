package pl.cortana.holo.data

import android.content.Context

class SettingsRepository(context: Context) {
    private val prefs = context.getSharedPreferences("cortana_settings_v1", Context.MODE_PRIVATE)

    var longTermMemoryEnabled: Boolean
        get() = prefs.getBoolean(KEY_MEMORY, false)
        set(value) { prefs.edit().putBoolean(KEY_MEMORY, value).apply() }

    var voiceRepliesEnabled: Boolean
        get() = prefs.getBoolean(KEY_VOICE, false)
        set(value) { prefs.edit().putBoolean(KEY_VOICE, value).apply() }

    private companion object {
        const val KEY_MEMORY = "long_term_memory_enabled"
        const val KEY_VOICE = "voice_replies_enabled"
    }
}
