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
    while (true) {
        print("AptScript> ")
        val input = readLine() ?: continue

        if (input == "exit()") { break }

        val lexer = Lexer("<stdin>", input)
        val res = lexer.make_tokens()

        if (res.second != null) {
            error(res.second!!)
        }
        else
        {
            println(res.first)
        }
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