package common.validation

object Validation {
    fun isNumeric(str: String): Boolean {
        return str.matches("-?\\d+(\\.\\d+)?".toRegex())
    }

    fun isNotNumeric(str: String): Boolean {
        return !isNumeric(str)
    }
}