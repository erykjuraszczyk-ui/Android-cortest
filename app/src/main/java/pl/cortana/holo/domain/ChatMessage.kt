package pl.cortana.holo.domain

data class ChatMessage(
    val id: Long,
    val role: Role,
    val content: String,
    val createdAtEpochMs: Long
) {
    enum class Role { USER, ASSISTANT, SYSTEM }
}
