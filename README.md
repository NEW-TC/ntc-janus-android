# НТК Привратник (NTC Janus) — Android

Мобильное приложение видеодомофона для бизнес-центров. Разработано НТК (Новая Телекоммуникационная Компания, [new-tc.ru](https://new-tc.ru)) на основе открытого проекта [Linhome](https://github.com/BelledonneCommunications/linhome-android) компании Belledonne Communications.

Описание сервиса: https://new-tc.ru/intercom/domofoniya.php

## Лицензия

Проект распространяется на условиях **GNU GPL v3** (см. [LICENSE.txt](LICENSE.txt)), как и исходный Linhome. Авторские права на исходный код Linhome принадлежат Belledonne Communications SARL; заголовки авторских прав в файлах сохранены. Приложение использует Linphone SDK (Belledonne Communications, GPL v3).

## Что изменено относительно Linhome

- Обновлена сборка: Gradle 8, Android Gradle Plugin 8, Kotlin 1.9, Linphone SDK 5.4, targetSdk 35.
- Брендинг НТК, русский язык интерфейса, собственная тема (`ntc-theme/`).
- Убраны Firebase и все обращения к серверам Belledonne (STUN, метрики, загрузка журналов, аккаунты Linhome).
- Ручной вход по SIP с отдельными полями SIP ID, Auth ID, Сервер и Пароль.
- Импорт устройства (вызывной панели) из ссылки или QR-кода настройки (секции `ntc_device_N`).
- Индикатор состояния SIP-соединения, отправка журнала через системное меню «Поделиться».

## Сборка

Нужны JDK 17 и Android SDK (platform 35, build-tools 35).

```
export ANDROID_HOME=/путь/к/android-sdk
./gradlew assembleRelease
```

Для подписанной сборки создайте файл `keystore.properties` в корне проекта (он в `.gitignore` и никогда не публикуется):

```
storeFile=/путь/к/ключу.jks
storePassword=...
keyAlias=...
keyPassword=...
```

Без этого файла `assembleRelease` соберёт неподписанный APK. Ключ подписи хранится отдельно и в репозиторий не входит.

Вспомогательные скрипты в `scripts/`:
- `gen_view_accessors.py` — генерация акцессоров view из layout-XML (замена удалённому `kotlin-android-extensions`);
- `apply_ru_texts.py` — русские тексты и бренд в `ntc-theme/texts.xml`.

## Связь с исходным проектом

Ветка `main` содержит историю Linhome, поверх неё — изменения НТК. Обновления Linhome можно подтягивать из `upstream`:

```
git remote add upstream https://github.com/BelledonneCommunications/linhome-android
```
