package pl.cortana.holo

import org.junit.Assert.assertEquals
import org.junit.Test

class VersionTest {
    @Test
    fun projectVersionIs080() {
        assertEquals("0.8.0", BuildConfig.VERSION_NAME)
    }
}
