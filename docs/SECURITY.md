# Security and privacy baseline

## Data boundaries

- Conversation history is stored in app-private SharedPreferences.
- History is local to the installation; no cloud sync is implemented in this build.
- Long-term-memory and voice-reply preferences default to disabled.
- The app requests microphone permission only after the user taps the microphone control.
- This release does not capture audio or transmit microphone data.
- The offline assistant clearly reports that the AI backend is not configured.

## Backend integration requirements

Before connecting a hosted model:

1. Use HTTPS only.
2. Keep provider API keys on the backend, never inside the APK/AAB.
3. Authenticate users and validate sessions server-side.
4. Apply request limits, abuse controls and safe logging.
5. Define data retention, deletion and export behavior.
6. Do not log raw conversation text unless necessary and disclosed.
7. Make cloud memory opt-in and provide a deletion path.

## Android permissions

The manifest declares INTERNET and RECORD_AUDIO. RECORD_AUDIO is requested at runtime only after an explicit user action. Camera permission is not declared because camera functionality is not implemented in this build.

## Limitations

This baseline is not a complete security certification. A production release requires dependency review, threat modeling, backend security review, privacy-policy review and device testing.
