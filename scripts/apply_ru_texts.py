#!/usr/bin/env python3
"""Добавляет русские переводы (<entry name="ru">) и бренд НТК в ntc-theme/texts.xml.
Идемпотентен: существующие ru-записи заменяются. Запуск из корня репозитория."""
import re

BRAND = {  # меняют и default
    'appname': 'НТК Привратник',
    'support_email_android': 'ez@new-tc.ru',
    'about_link': 'new-tc.ru/intercom/domofoniya.php',
    'copyright_text': '© НТК. Основано на Linhome © Belledonne Communications',
    'device_address_hint': 'например: sip:4001@voip.new-tc.ru',
    'splash_title': 'Видеодомофон для бизнес-центров',
}
RU = {
'appname':'НТК Привратник','splash_title':'Видеодомофон для бизнес-центров',
'devices':'Устройства','history':'История','assistant':'Мастер настройки',
'history_no_media_found':'Нет аудио- или видеозаписи','history_unregistered_device':'Неизвестное устройство',
'history_call_new':'новый','history_list_call_date_type':'{0} в {1}',
'history_list_call_type_missed':'Пропущен','history_list_call_type_declined':'Отклонён','history_list_call_type_accepted':'Принят',
'history_list_call_type_called':'Исходящий','history_list_call_type_aborted':'Прерван',
'history_select_all':'Выбрать все','history_deselect_all':'Снять выбор','delete_history_confirm_message':'Удалить событий: {0}?',
'history_empty_list_title':'Событий пока нет','menu_assistant':'Настройка аккаунта','menu_account':'Мой аккаунт',
'menu_settings':'Настройки','menu_about':'О приложении','menu_disconnect':'Отключить аккаунт',
'disconnect_confirm_message':'Отключить аккаунт?','assistant_welcome_title':'Добро пожаловать',
'assistant_welcome_subtitle':'Мастер поможет настроить ваш аккаунт.',
'assistant_create_linhome_account':'Создать аккаунт {appname}','assistant_use_linhome_account':'Войти в аккаунт {appname}',
'assistant_use_sip_account':'Войти по SIP-аккаунту','assistant_remote_prov':'Настройка по ссылке или QR',
'assistant_remote_url':'По ссылке','assistant_remote_prov_from_url':'Настройка по ссылке',
'assistant_remote_prov_infobubble':'Приложение настроится автоматически по ссылке на конфигурацию, выданной в личном кабинете new-tc.ru/intercom.',
'assistant_remote_prov_from_qr_infobubble':'Отсканируйте QR-код из личного кабинета, чтобы загрузить настройки приложения.',
'remote_configuration_success':'Настройки успешно применены','remote_configuration_failed':'Не удалось применить настройки',
'remote_configuration_skipped':'Настройка пропущена','url':'Ссылка','assistant_remote_qr':'По QR-коду',
'assistant_remote_from_qr':'Настройка по QR-коду','assistant_remote_from_qr_desc':'Отсканируйте QR-код из личного кабинета.',
'assistant_using_will_disconnect_title':'Аккаунт уже настроен',
'assistant_using_will_disconnect_message':'Если продолжить, текущий аккаунт будет отключён. Продолжить?',
'username':'SIP ID','auth_id':'Auth ID','background_settings':'Работа в фоне','invalid_proxy_address':'Прокси: host, host:порт или sips:host:порт','devices_sip_status_label':'SIP-соединение:','devices_no_account':'Аккаунт не настроен','invalid_sip_id':'SIP ID: user, user@сервер или sip:user@сервер (только буквы, цифры и . _ + -)','invalid_auth_id':'Auth ID не должен содержать пробелов, «:» и «@»','email':'E-mail','password':'Пароль','password_confirmation':'Подтверждение пароля',
'create_account':'Создать аккаунт','login':'Войти','input_invalid_empty_field':'Обязательное поле',
'input_invalid_format_uri':'Неверный формат URI','invalid_host_name':'Неверный формат адреса','invalid_number':'Неверный формат числа',
'invalid_sip_uri':'Неверный формат SIP (sip: или sips:...)','invalid_action_code':'0-9 # *','action_type_missing':'Выберите действие',
'proxy':'прокси','register_expiration':'Срок регистрации',
'account_creator_username_too_short':'Слишком короткое имя','account_creator_username_too_long':'Слишком длинное имя',
'account_creator_username_invalid_characters':'Недопустимые символы','account_creator_username_invalid':'Недопустимое имя',
'account_creator_password_too_short':'Слишком короткий пароль','account_creator_password_too_long':'Слишком длинный пароль',
'account_creator_password_invalid_characters':'Недопустимые символы','account_creator_password_missingchars':'Не хватает символов',
'account_creator_email_malformed':'Неверный формат e-mail','account_creator_email_invalid_characters':'Недопустимые символы',
'account_creator_domain_invalid':'Неверное доменное имя','input_password_do_not_match':'Пароли не совпадают',
'linhome_account_username_already_exists':'Это имя уже занято','linhome_account_loggedin':'Аккаунт {appname} подключён',
'linhome_account_login_failed_unknown_user_or_wroong_password':'Неизвестный пользователь или неверный пароль',
'sip_account_created':'SIP-аккаунт настроен',
'failed_creating_pushgateway':'Не удалось настроить push-уведомления. Входящие вызовы будут приходить только при открытом приложении.',
'more_settings':'Дополнительные настройки','domain':'Сервер','transport':'Транспорт',
'camera_permission_denied_dont_ask_again':'Для {appname} нужен доступ к камере.',
'camera_permission_denied':'Для сканирования QR-кода нужен доступ к камере.',
'record_audio_permission_denied':'Для исходящих вызовов нужен доступ к микрофону.',
'record_audio_permission_denied_dont_ask_again':'Разрешите {appname} доступ к микрофону в настройках телефона.',
'write_external_storage_permission_denied':'Для записи вызовов нужен доступ к хранилищу.',
'write_external_storage_permission_denied_dont_ask_again':'Разрешите {appname} запись в хранилище в настройках телефона, чтобы сохранять записи вызовов.',
'delete_account':'Удалить аккаунт','change_password':'Сменить пароль',
'no_account_configured':'Аккаунт не настроен.\nНастройте его через мастер настройки.',
'account_info':'Аккаунт: {0} \nSIP-соединение: {1}','push_account_info':'Push-аккаунт: {0} \n {1}',
'refresh_registers':'Обновить соединение','account_manage_on_freesip_title':'Управление аккаунтом {appname}',
'account_manage_on_freesip_message':'Аккаунтом управляет администратор НТК. Если пароль изменён, отключите аккаунт и настройте его заново.',
'registration_state_none':'Не подключено','registration_state_progress':'Подключение…','registration_state_ok':'Подключено',
'registration_state_failed':'Ошибка подключения','registration_state_cleared':'Не подключено',
'audio_codecs':'Аудиокодеки','video_codecs':'Видеокодеки','log_upload_failed':'Произошла ошибка, повторите позже.',
'log_upload_success':'Журнал загружен. Ссылка скопирована в буфер обмена.','enable_debuglogs':'Включить журнал отладки',
'clear_logs':'Удалить файл журнала','log_clear_success':'Файл журнала удалён.','send_logs':'Отправить журнал',
'unable_to_sendMail_from_this_device':'Не удалось отправить письмо с этого устройства. Журнал доступен по ссылке: {0}',
'copy_url_to_clipboard':'Скопировать ссылку','enable_ipv6':'Включить IPv6','media_encryption':'Шифрование медиа',
'settings_device_show_latest_snapshot':'Показывать последние снимки в списке устройств.','your_device':'Ваше устройство',
'device_info_actions_title':'Настроенные действия','device_info_no_actions_title':'Действия не настроены',
'delete_device_confirm_message':'Удалить устройство {0}?',
'devices_empty_list_title':'Добавьте домофоны, камеры и внутренние блоки, чтобы видеть, что происходит у входа, и звонить на них.',
'new_device':'Новое устройство','device_name':'Название устройства','device_address':'SIP-адрес',
'device_address_already_exists':'Устройство с таким SIP-адресом уже есть ({0}).','device_address_hint':'например: sip:4001@voip.new-tc.ru',
'device_type_select':'Выберите тип устройства','device_type_select_prompt':'Выберите тип',
'method_type_select':'Настройка кнопок действий (необязательно)','action_method':'Метод','action_method_prompt':'Выберите метод',
'method_dtmf_sip_info':'DTMF (SIP INFO)','method_dtmf_rfc_4733':'DTMF (RFC 4733)','method_sip_message':'SIP-сообщение',
'action':'действие','action_prompt':'Выберите действие','action_open_door':'Открыть дверь','action_open_gate':'Открыть ворота',
'action_lightup':'Включить свет','action_unlock':'Разблокировать','action_code':'Код',
'device_video_intercom':'Видеодомофон','device_audio_intercom':'Аудиодомофон','device_security_camera':'SIP-камера',
'device_internal_unit':'Внутренний блок','device_action':'Действие','device_action_select':'Выберите действие',
'device_action_add':'Добавить действие','delete_device':'Удалить устройство','about_link':'new-tc.ru/intercom/domofoniya.php',
'license_text':'GNU General Public License v3','copyright_text':'© НТК. Основано на Linhome © Belledonne Communications',
'message':'сообщение','ok':'Ок','cancel':'Отмена','confirm':'Подтвердить','yes':'Да','no':'Нет','apply':'Применить',
'generic_dialog_error_title':'Ошибка','none':'Нет','save':'Сохранить','select':'Выбрать','edit':'Изменить',
'today':'Сегодня','yesterday':'Вчера','incoming_someone_at_your_door':'Кто-то звонит в домофон.',
'call_button_accept':'Принять','call_button_decline':'Отклонить','call_button_cancel':'Отмена','call_button_hangup':'Завершить',
'call_button_mute':'Выключить звук','call_button_unmute':'Включить звук','call_button_enable_speaker':'Включить',
'call_button_disable_speaker':'Выключить',
'unable_to_call_device':'Не удалось дозвониться до устройства. Проверьте его настройки и подключение к сети.',
'notif_incoming_call':'Входящий вызов','notif_incoming_call_audio':'Аудиовызов','notif_incoming_call_video':'Видеовызов',
'notif_missed_call_title':'Пропущенные вызовы','notif_missed_calls':'Пропущенных вызовов: {0}','notif_missed_call':'пропущенный вызов от {0}',
'notif_outgoing_call':'Исходящий вызов','notif_in_call':'Идёт разговор',
'notification_channel_service_name':'Служба {appname}','notification_channel_incoming_call_name':'{appname}: входящий вызов',
'service_name':'Служба {appname}','service_auto_start_description':'{appname} запущено автоматически.',
'service_description':'Без push-уведомлений входящие вызовы приходят только при открытом приложении. Звонить на устройства можно в любом случае.',
'linhome_account_created':'Аккаунт {appname} {0} создан.','linhome_account_creation_failed':'Произошла ошибка. Повторите позже. Код ошибки: {0}',
'linhome_account_creation_request_failed':'Запрос не выполнен. Повторите позже.',
}

p = 'ntc-theme/texts.xml'
s = open(p, encoding='utf-8').read()

def esc(t):
    return t.replace('&', '&amp;').replace('<', '&lt;').replace('>', '&gt;')

def section_sub(m):
    name, body = m.group(1), m.group(2)
    if name in BRAND:
        body = re.sub(r'(<entry name="default">).*?(</entry>)', lambda x: x.group(1) + esc(BRAND[name]) + x.group(2), body, flags=re.S)
    body = re.sub(r'\s*<entry name="ru">.*?</entry>', '', body, flags=re.S)
    if name in RU:
        body = re.sub(r'(<entry name="default">.*?</entry>)', lambda x: x.group(1) + '\n\t\t<entry name="ru">' + esc(RU[name]) + '</entry>', body, count=1, flags=re.S)
    return '<section name="%s">%s</section>' % (name, body)

s = re.sub(r'<section name="([^"]+)">(.*?)</section>', section_sub, s, flags=re.S)
open(p, 'w', encoding='utf-8').write(s)
import xml.etree.ElementTree as ET
r = ET.parse(p).getroot()
have = {x.get('name') for x in r.iter('section') if any(e.get('name') == 'ru' for e in x.iter('entry'))}
print('ru sections:', len(have), 'missing keys in xml:', sorted(set(RU) - {x.get('name') for x in r.iter('section')}))
