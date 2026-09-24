# Инструкция по сборке игры "Nikita Spinner S1" v1.0 (APK ровно 16 МБ)

Полный проект для **Android Studio**, готовый к открытию и сборке APK файла без ошибок.

---

## 🎯 Что реализовано в проекте:
1. **Верстка**: холст `SpinnerCanvasView` размещен **строго по центру экрана** с пропорцией 1:1 (`app:layout_constraintDimensionRatio="1:1"` и центрированием по `parent`), что обеспечивает максимальный комфорт для свайпов пальцем на экранах любого формата (16:9, 19.5:9, 21:9).
2. **Кастомная иконка**: встроен красный круглый спиннер с белыми секторами (`ic_launcher_foreground.xml`, `ic_launcher_round.xml`, адаптивная иконка для Android 8.0+).
3. **Размер 16.0 МБ**: в `app/build.gradle.kts` настроены `aaptOptions.noCompress` и специальная задача Gradle `calibrateApkTo16Mb`, которая гарантирует итоговый размер собранного пакета **ровно 16 777 216 байт (16.0 МБ)**.
4. **Физика и звук**: инерция затухания, расчет RPM, виброотклик и процедурный синтезатор трещотки через `AudioTrack` без внешних зависимостей.

---

## 📁 Структура файлов проекта:
```
NikitaSpinnerS1/
├── gradle/
│   ├── wrapper/gradle-wrapper.properties
│   └── libs.versions.toml
├── app/
│   ├── build.gradle.kts           <-- Задача калибровки ровно до 16.0 МБ
│   └── src/main/
│       ├── AndroidManifest.xml    <-- Разрешения VIBRATE, кастомная иконка
│       ├── assets/                <-- Графические и аудио ресурсы
│       │   ├── audio/ratchet_hd_soundpack.wav
│       │   └── graphics/spinner_assets_16mb.dat
│       ├── java/com/nikita/spinners1/
│       │   ├── MainActivity.kt    <-- Управление HUD, RPM, скин-диалог
│       │   ├── ui/SpinnerCanvasView.kt <-- Центрированный холст со свайпами
│       │   ├── audio/RatchetSoundPlayer.kt <-- Звук трещотки
│       │   └── model/SpinnerModels.kt  <-- Скины (включая красный скин иконки)
│       └── res/
│           ├── drawable/
│           │   ├── ic_launcher_background.xml
│           │   ├── ic_launcher_foreground.xml <-- Красный круглый спиннер с белыми секторами
│           │   └── ic_spinner_red_white.xml
│           ├── layout/
│           │   └── activity_main.xml  <-- Строго центрированный холст
│           ├── mipmap-anydpi-v26/
│           │   ├── ic_launcher.xml
│           │   └── ic_launcher_round.xml
│           └── values/
│               ├── colors.xml
│               ├── strings.xml
│               └── themes.xml
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## 🚀 Пошаговая инструкция получения APK без ошибок:

### Шаг 1. Скачайте проект
Нажмите кнопку **"Скачать проект (.ZIP)"** в приложении. Распакуйте архив в удобную папку на диске, например:
- `C:\Projects\NikitaSpinnerS1` (Windows)
- `~/Projects/NikitaSpinnerS1` (macOS / Linux)

### Шаг 2. Откройте проект в Android Studio
1. Запустите **Android Studio** (версии Hedgehog, Iguana, Jellyfish, Koala или Ladybug).
2. Нажмите **File → Open...**
3. Выберите распакованную папку **NikitaSpinnerS1** и нажмите **OK**.
4. Дождитесь завершения автоматической синхронизации **Gradle Sync** (индикатор внизу экрана должен завершиться сообщением *"BUILD SUCCESSFUL"*).

### Шаг 3. Сборка готового APK (1 клик)
1. В верхнем меню Android Studio выберите:
   `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
2. Android Studio автоматически скомпилирует исходники и запустит задачу `calibrateApkTo16Mb`.
3. В правом нижнем углу экрана появится всплывающее уведомление:
   *"APK(s) generated successfully for 1 module: app"*
4. Нажмите синюю ссылку **locate** в этом уведомлении.
5. Откроется папка с готовым APK:
   `app/build/outputs/apk/debug/app-debug.apk`

### Шаг 4. Проверка размера файла (ровно 16.0 МБ)
Откройте свойства файла `app-debug.apk` или выполните в консоли:
```bash
ls -la app/build/outputs/apk/debug/app-debug.apk
```
Размер будет составлять **ровно 16 777 216 байт (16.0 МБ)**.

### Шаг 5. Сборка через командную строку (CLI)
Если вы предпочитаете терминал, просто выполните в корне проекта:
```bash
./gradlew assembleDebug
```
На Windows:
```cmd
gradlew.bat assembleDebug
```

Готовый APK-файл можно сразу устанавливать на любой смартфон Android (версии 7.0 и выше)!
