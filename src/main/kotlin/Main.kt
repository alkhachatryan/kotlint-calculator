import io.kaen.dagger.ExpressionParser

fun main() {
    println("Type the calculating operation: ")

    val parser = ExpressionParser()
    val result = parser.evaluate(readln())
    println(result)
}