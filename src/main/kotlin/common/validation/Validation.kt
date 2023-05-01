package common.validation

object Validation {
    fun isNumeric(str: String): Boolean {
        return str.matches("-?\\d+(\\.\\d+)?".toRegex())
    }

    fun isNonPositiveNumeric(str: String): Boolean {
        return str.matches("-\\d+(\\.\\d+)?".toRegex())
    }

    fun isNotNumeric(str: String): Boolean {
        return !isNumeric(str)
    }

    fun hasDuplicateNumbers(numbers: List<Int>): Boolean {
        val set = HashSet<Int>()
        for (number in numbers) {
            if (!set.add(number)) {
                return true
            }
        }
        return false
    }
}