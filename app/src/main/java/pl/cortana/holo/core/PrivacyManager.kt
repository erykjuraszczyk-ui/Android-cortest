package pl.cortana.holo.core

import android.content.Context
import pl.cortana.holo.data.ChatRepository
import pl.cortana.holo.data.SettingsRepository

class PrivacyManager(
    private val chatRepository: ChatRepository,
    private val settingsRepository: SettingsRepository,
    context: Context
) {
    private val appContext = context.applicationContext

    fun clearLocalConversation() {
        chatRepository.clear()
    }

    fun clearLocalPreferences() {
        settingsRepository.longTermMemoryEnabled = false
        settingsRepository.voiceRepliesEnabled = false
        appContext.getSharedPreferences("cortana_chat_v1", Context.MODE_PRIVATE)
            .edit().clear().apply()
    }
}
