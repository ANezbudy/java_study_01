package KotlinStudy.strings

import java.lang.StringBuilder

fun<T> joinToString(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if(index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    println(joinToString(setOf(1, 5, 18, 4), separator = ";  " +
            "", prefix = "(", postfix = ")"))
}