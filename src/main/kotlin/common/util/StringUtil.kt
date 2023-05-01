package common.util

object StringUtil {
    fun split(targetString: String, delimiter: String): List<String> {
        return targetString.split(delimiter)
            .map { it.trim() }
            .filter { it.isNotBlank() }
    }
}