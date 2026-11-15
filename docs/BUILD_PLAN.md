# Cortana Android — plan budowy

## BUILD 1/3 — Foundation

- [x] Projekt Android Kotlin i konfiguracja Gradle
- [x] Android 13+ (minSdk 33)
- [x] Manifest, motyw i główna aktywność
- [x] Podstawowy ekran rozmowy

## BUILD 2/3 — Assistant Core

- [x] Model wiadomości domenowych
- [x] Lokalna historia w pamięci prywatnej aplikacji
- [x] Kontrakt `AiAssistant` oddzielający UI od backendu
- [x] Jawny tryb offline bez udawania połączenia z modelem
- [x] Ustawienia pamięci długoterminowej i odpowiedzi głosowych

## BUILD 3/3 — Security & Quality

- [ ] Uwierzytelnianie backendu i zarządzanie sesją
- [ ] Polityka prywatności i eksport/usuwanie danych
- [ ] Voice Core z obsługą cyklu życia mikrofonu
- [ ] Testy jednostkowe i instrumentacyjne
- [ ] CI: kompilacja debug/release i kontrola statyczna

## FINAL — Release

- [ ] Kontrola integracji i zależności
- [ ] Budowanie APK i AAB
- [ ] Weryfikacja instalacji na Androidzie 13+
- [ ] Notatki wydania i instrukcja dystrybucji

Status checklisty ma odzwierciedlać rzeczywiste wykonanie. Etapy wymagające uruchomienia Gradle lub testów urządzeniowych nie są uznawane za zaliczone bez wyników CI albo lokalnego builda.
