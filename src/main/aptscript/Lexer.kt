const val TT_INT	    = "INT"
const val TT_FLOAT    = "FLOAT"
const val TT_PLUS     = "PLUS"
const val TT_MINUS    = "MINUS"
const val TT_MUL      = "MUL"
const val TT_DIV      = "DIV"
const val TT_LPAREN   = "LPAREN"
const val TT_RPAREN   = "RPAREN"

class Lexer(val fn: String, val text: String, var current_char: Char? = null) {
    var pos: Position = Position(-1, 0, -1, this.fn, this.text)

    init {
        this.advance()
    }

    fun advance() {
        this.current_char?.let { this.pos.advance(it) }
        if (pos.idx < this.text.length) {
            this.current_char = this.text[this.pos.idx]
        }
        else
        {
            this.current_char = null
        }
    }

    fun make_tokens(): Pair<Array<Token>, Any?> {
        var tokens: Array<Token> = emptyArray()

        while (this.current_char != null) {
            if (this.current_char == '\t') {
                this.advance()
            }
            else if (this.current_char!!.isDigit()) {
                // Make number
            }
            else if (this.current_char == '+') {
                tokens[tokens.size + 1] = Token(TT_PLUS)
                this.advance()
            }
            else if (this.current_char == '-') {
                tokens[tokens.size + 1] = Token(TT_MINUS)
                this.advance()
            }
            else if (this.current_char == '*') {
                tokens[tokens.size + 1] = Token(TT_MUL)
                this.advance()
            }
            else if (this.current_char == '/') {
                tokens[tokens.size + 1] = Token(TT_DIV)
                this.advance()
            }
            else if (this.current_char == '(') {
                tokens[tokens.size + 1] = Token(TT_LPAREN)
                this.advance()
            }
            else if (this.current_char == ')') {
                tokens[tokens.size + 1] = Token(TT_RPAREN)
                this.advance()
            }
            else {
                var pos_start = pos.copy()
                val char = this.current_char
                this.advance()
                return Pair(emptyArray(), Error("IllegalCharError"))
            }
        }
        return Pair(tokens, null)
    }

    fun make_number(): Any {
        var num_str: String = ""
        var dot_count: Int = 0
        val digits = "0123456789."
        while (this.current_char!! in digits) {
            if (this.current_char == null) { break }

            if (this.current_char == '.') {
                if (dot_count == 1) { break }
                dot_count += 1
                num_str += '.'
            }
            else
            {
                num_str += this.current_char
            }
            this.advance()
        }

        if (dot_count == 0) {
            return Token(TT_INT, num_str.toInt())
        }
        else
        {
            return Token(TT_FLOAT, num_str.toFloat())
        }
    }
}
