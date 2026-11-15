# CORTANA HOLO — Android

Natywna aplikacja asystenta AI dla Androida 13+ (API 33+), rozwijana w Kotlinie.

## Plan budowy

Projekt jest realizowany w czterech kontrolowanych krokach:

1. **BUILD 1/3 — Foundation:** projekt Gradle, konfiguracja Android, manifest, motyw i główny ekran.
2. **BUILD 2/3 — Assistant Core:** interfejs rozmowy, repozytorium wiadomości, lokalna historia i kontrakt klienta AI.
3. **BUILD 3/3 — Security & Quality:** ustawienia prywatności, obsługa uprawnień, diagnostyka, testy i dokumentacja.
4. **FINAL — Release:** przegląd integracji, instrukcja budowania, walidacja APK/AAB i podsumowanie wydania.

## Wymagania

- Android Studio z aktualnym Android SDK
- JDK 17
- Android SDK Platform 35
- Android Gradle Plugin zgodny z Gradle Wrapper

## Konfiguracja docelowa

- applicationId: `pl.cortana.holo`
- minSdk: 33 (Android 13)
- targetSdk: 35
- compileSdk: 35
- Kotlin + AndroidX + Material 3

## Status

Aktualnie realizowany jest **BUILD 1/3**. Funkcje AI wymagają skonfigurowanego backendu. Repozytorium nie zawiera kluczy API; sekrety nie mogą trafiać do aplikacji mobilnej.

## Architektura

```
app/
  src/main/
    java/pl/cortana/holo/
      MainActivity.kt
      ui/
      data/
      domain/
      core/
    res/
    AndroidManifest.xml
docs/
  BUILD_PLAN.md
  SECURITY.md
```

## Bezpieczeństwo

Nie umieszczaj kluczy API ani haseł w kodzie, zasobach, plikach Gradle ani repozytorium. Docelowa komunikacja z modelem AI powinna przechodzić przez backend z uwierzytelnianiem i ograniczaniem dostępu.

## Licencja

Licencja zostanie określona przez właściciela repozytorium przed publiczną dystrybucją.
