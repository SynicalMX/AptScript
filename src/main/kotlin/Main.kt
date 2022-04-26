import java.io.File
import java.io.BufferedReader

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        withparams(args)
    }
    else {
        interpreter()
    }
}

fun interpreter() {
    println("wip")
}

fun withparams(args: Array<String>) {
    for (i in args.indices) {
        if (args[i] == "-f") {
            val bufferedReader: BufferedReader = File(args[i+1]).bufferedReader()
            val inputString = bufferedReader.use { it.readText() }
            println(inputString)
        }
    }
}