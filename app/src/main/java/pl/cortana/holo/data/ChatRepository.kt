package pl.cortana.holo.data

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import pl.cortana.holo.domain.ChatMessage

/**
 * Lightweight local conversation persistence.
 * Stored in app-private preferences; never exported automatically.
 */
class ChatRepository(context: Context) {
    private val prefs = context.getSharedPreferences("cortana_chat_v1", Context.MODE_PRIVATE)

    fun load(): List<ChatMessage> {
        val raw = prefs.getString(KEY_MESSAGES, "[]") ?: "[]"
        return runCatching {
            val array = JSONArray(raw)
            buildList {
                for (index in 0 until array.length()) {
                    val item = array.getJSONObject(index)
                    add(
                        ChatMessage(
                            id = item.getLong("id"),
                            role = ChatMessage.Role.valueOf(item.getString("role")),
                            content = item.getString("content"),
                            createdAtEpochMs = item.getLong("createdAt")
                        )
                    )
                }
            }
        }.getOrDefault(emptyList())
    }

    fun append(message: ChatMessage) {
        val messages = load().toMutableList().apply { add(message) }
        val array = JSONArray()
        messages.takeLast(MAX_MESSAGES).forEach { message ->
            array.put(
                JSONObject()
                    .put("id", message.id)
                    .put("role", message.role.name)
                    .put("content", message.content)
                    .put("createdAt", message.createdAtEpochMs)
            )
        }
        prefs.edit().putString(KEY_MESSAGES, array.toString()).apply()
    }

    fun clear() {
        prefs.edit().remove(KEY_MESSAGES).apply()
    }

    private companion object {
        const val KEY_MESSAGES = "messages"
        const val MAX_MESSAGES = 300
    }
}
