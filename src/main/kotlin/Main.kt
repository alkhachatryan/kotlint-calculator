fun main(args: Array<String>) {
    println("Type the calculating operation: ")
    print(resolveOperation(readln()))
}

fun resolveOperation(operationsStr: String): Float {
    val numbers = operationsStr.split('+', '-', '/', '*').toMutableList()
    val operations = operationsStr.split(regex = Regex("""\d+""")).toMutableList()

    val operationsWithHighPrior = listOf("*", "/");
    val operationsWithLowPrior = listOf("+", "-");
    var modifiedStatement = ""
    operations.removeIf { it == "" || it == "."}

    for(i in operations.indices) {
        val op = operations[i];

        if(! operationsWithHighPrior.contains(op)) {
            continue
        }

        val firstNumIndex = i
        val secondNumIndex = i + 1
        var result = 0F

        if(op == "*") {
            result = numbers[firstNumIndex].toFloat() * numbers[secondNumIndex].toFloat()
        }
        else if(op == "/") {
            result = numbers[firstNumIndex].toFloat() / numbers[secondNumIndex].toFloat()
        }

        numbers[firstNumIndex] = result.toString()
        numbers.removeAt(secondNumIndex)
        operations.removeAt(i)

        return if(operations.size == 0) {
            result
        } else {
            for (numberIndex in numbers.indices) {
                modifiedStatement += numbers[numberIndex]

                if(numberIndex + 1 != numbers.size) {
                    modifiedStatement += operations[numberIndex]
                }
            }

            resolveOperation(modifiedStatement)
        }
    }

    for(i in operations.indices) {
        val op = operations[i];
        if(! operationsWithLowPrior.contains(op)) {
            continue
        }
        val firstNumIndex = i
        val secondNumIndex = i + 1
        var result = 0F


        if(op == "+") {
            result = numbers[firstNumIndex].toFloat() + numbers[secondNumIndex].toFloat()
        }
        else if(op == "-") {
            result = numbers[firstNumIndex].toFloat() - numbers[secondNumIndex].toFloat()
        }

        numbers[firstNumIndex] = result.toString()
        numbers.removeAt(secondNumIndex)
        operations.removeAt(i)

        return if(operations.size == 0) {
            result
        } else {
            for (numberIndex in numbers.indices) {
                modifiedStatement += numbers[numberIndex]

                if(numberIndex + 1 != numbers.size) {
                    modifiedStatement += operations[numberIndex]
                }
            }

            resolveOperation(modifiedStatement)
        }
    }

    return 0F
}