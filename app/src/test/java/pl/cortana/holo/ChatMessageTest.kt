package pl.cortana.holo

import org.junit.Assert.assertEquals
import org.junit.Test
import pl.cortana.holo.domain.ChatMessage

class ChatMessageTest {
    @Test
    fun messageRetainsRoleAndContent() {
        val message = ChatMessage(
            id = 1L,
            role = ChatMessage.Role.USER,
            content = "Cześć Cortana",
            createdAtEpochMs = 100L
        )
        assertEquals(ChatMessage.Role.USER, message.role)
        assertEquals("Cześć Cortana", message.content)
    }
}
