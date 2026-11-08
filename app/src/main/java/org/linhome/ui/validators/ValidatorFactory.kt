/*
 * Copyright (c) 2010-2020 Belledonne Communications SARL.
 *
 * This file is part of linhome-android
 * (see https://www.linhome.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.linhome.ui.validators

class ValidatorFactory {
    companion object {
        val nonEmptyStringValidator = NonEmptyStringValidator()
        val uriValidator = NonEmptyUrlFormatValidator()
        val hostnameEmptyOrValidValidator =
            RegExpFormatValidator("^[a-zA-Z0-9.]*$", "invalid_host_name")
        // Прокси: пусто, "host", "host:порт", "sip:host:порт", "sips:host:порт", допустимы ;параметры (например ;transport=tls)
        val proxyAddress = RegExpFormatValidator(
            "^(?i:(?:sips?:)?[a-z0-9.\\-]+(?::[0-9]{1,5})?(?:;[a-z0-9_.=\\-]+)*)?$", "invalid_proxy_address")
        val numberEmptyOrValidValidator = RegExpFormatValidator("^[0-9]*$", "invalid_number")
        val numberNonEmptyOrValidValidator = RegExpFormatValidator("^[0-9]+$", "invalid_number")
        val sipUri =
            NonEmptyWithRegExpFormatValidator("^([^@]+)(?:@(.+))?$", "invalid_sip_uri")
        // SIP ID: "user", "user@server" или "sip:user@server"; имя пользователя - буквы, цифры и . _ + -
        val sipId = NonEmptyWithRegExpFormatValidator("^(?i:sips?:)?[A-Za-z0-9._+\\-]+(?:@[A-Za-z0-9.\\-]+)?$", "invalid_sip_id")
        // Auth ID: любые символы кроме пробелов, ":" и "@"
        val authId = NonEmptyWithRegExpFormatValidator("^[^\\s:@]+$", "invalid_auth_id")
        val actionCode = RegExpFormatValidator("^[0-9#*]+$", "invalid_action_code")
    }
}