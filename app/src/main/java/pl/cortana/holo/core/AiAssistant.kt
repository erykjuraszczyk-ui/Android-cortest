package pl.cortana.holo.core

/**
 * Boundary between the Android UI and a future authenticated AI backend.
 * No API key or provider credential belongs in the Android application.
 */
interface AiAssistant {
    suspend fun reply(
        userMessage: String,
        conversation: List<ConversationTurn>
    ): AssistantResult
}

data class ConversationTurn(
    val role: String,
    val content: String
)

sealed interface AssistantResult {
    data class Success(val text: String) : AssistantResult
    data class Unavailable(val reason: String) : AssistantResult
}
