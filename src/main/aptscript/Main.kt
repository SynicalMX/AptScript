import java.io.File
import java.io.BufferedReader

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        withparams(args)
    }
    else {
        shell()
    }
}

fun shell() {
    var running: Boolean = true
    while (running) {
        print("AptScript> ")
        val input = readLine() ?: continue

        val lexer = Lexer("<stdin>", input)
    }
}

fun withparams(args: Array<String>) {
    for (i in args.indices) {
        if (args[i] == "-f") {
            val bufferedReader: BufferedReader = File(args[i+1]).bufferedReader()
            val file = bufferedReader.use { it.readText() }

            println(file)
        }
    }
}