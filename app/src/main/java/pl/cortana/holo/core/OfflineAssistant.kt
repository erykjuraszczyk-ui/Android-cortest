package pl.cortana.holo.core

/**
 * Explicit offline placeholder. It does not pretend to be a remote language model.
 */
class OfflineAssistant : AiAssistant {
    override suspend fun reply(
        userMessage: String,
        conversation: List<ConversationTurn>
    ): AssistantResult = AssistantResult.Unavailable(
        "Silnik AI nie jest jeszcze skonfigurowany. Interfejs i historia działają lokalnie."
    )
}
