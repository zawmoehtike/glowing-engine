package co.codigo.readytotravel

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * References:
 * https://mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
 * https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
 */
object InputCheckerUtil {
    private lateinit var pattern: Pattern
    private lateinit var matcher: Matcher
    val emailPattern = "[a-zA-Z0-9.-_]+@[a-zA-Z0-9.-]+\\.+[a-zA-Z0-9.-]+"

    fun validatePhoneNumber(number: String?): Boolean {
        return number!!.length >= 5 && number.length <=12
    }

    fun validateEmailAddress(email: String): Boolean {
        return Regex(emailPattern).matches(email)
    }
}