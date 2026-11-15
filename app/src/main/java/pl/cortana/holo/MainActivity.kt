package pl.cortana.holo

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding

class MainActivity : ComponentActivity() {
    private lateinit var conversation: LinearLayout
    private lateinit var input: EditText

    private val audioPermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        Toast.makeText(
            this,
            if (granted) "Mikrofon został udostępniony." else "Mikrofon pozostaje wyłączony.",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildInterface()
        addMessage("CORTANA", "System uruchomiony. Jestem gotowa do rozmowy tekstowej.")
    }

    private fun buildInterface() {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(20))
            setBackgroundColor(0xFF07111F.toInt())
        }

        val header = TextView(this).apply {
            text = "CORTANA  /  HOLO 0.8.0"
            textSize = 18f
            setTextColor(0xFF72DFFF.toInt())
            gravity = Gravity.CENTER
            setPadding(0, dp(18), 0, dp(12))
        }
        root.addView(header)

        val avatar = TextView(this).apply {
            text = "◉"
            textSize = 78f
            gravity = Gravity.CENTER
            setTextColor(0xFF55D6FF.toInt())
            setPadding(0, dp(12), 0, dp(8))
        }
        root.addView(avatar)

        val status = TextView(this).apply {
            text = "SYSTEM ONLINE  •  ANDROID 13+"
            textSize = 11f
            gravity = Gravity.CENTER
            setTextColor(0xFF8AA7BC.toInt())
            setPadding(0, 0, 0, dp(16))
        }
        root.addView(status)

        val scroll = ScrollView(this)
        conversation = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(12))
        }
        scroll.addView(conversation)
        root.addView(scroll, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f
        ))

        input = EditText(this).apply {
            hint = "Napisz do Cortany..."
            setTextColor(0xFFEAF7FF.toInt())
            setHintTextColor(0xFF7790A3.toInt())
            setSingleLine(true)
            imeOptions = EditorInfo.IME_ACTION_SEND
            setPadding(dp(14))
            setBackgroundColor(0xFF122338.toInt())
            setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    sendMessage()
                    true
                } else false
            }
        }
        root.addView(input, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, dp(54)
        ))

        val actions = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
        }
        val send = Button(this).apply {
            text = "WYŚLIJ"
            setOnClickListener { sendMessage() }
        }
        val mic = Button(this).apply {
            text = "MIKROFON"
            setOnClickListener { requestMicrophone() }
        }
        actions.addView(send, LinearLayout.LayoutParams(0, dp(52), 1f))
        actions.addView(mic, LinearLayout.LayoutParams(0, dp(52), 1f))
        root.addView(actions)
        setContentView(root)
    }

    private fun sendMessage() {
        val message = input.text.toString().trim()
        if (message.isEmpty()) return
        addMessage("TY", message)
        input.text.clear()
        addMessage("CORTANA", "Otrzymałam wiadomość. Połączenie z silnikiem AI zostanie aktywowane po skonfigurowaniu backendu.")
    }

    private fun addMessage(sender: String, body: String) {
        val view = TextView(this).apply {
            text = "$sender\n$body"
            textSize = 14f
            setTextColor(if (sender == "TY") 0xFFB7C8D8.toInt() else 0xFF9DE9FF.toInt())
            setPadding(dp(12))
            setBackgroundColor(0xFF102237.toInt())
        }
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { setMargins(0, dp(5), 0, dp(5)) }
        conversation.addView(view, params)
    }

    private fun requestMicrophone() {
        val permission = Manifest.permission.RECORD_AUDIO
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Mikrofon jest dostępny. Moduł Voice Core zostanie podłączony w kolejnym etapie.", Toast.LENGTH_LONG).show()
        } else {
            audioPermission.launch(permission)
        }
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()
}
