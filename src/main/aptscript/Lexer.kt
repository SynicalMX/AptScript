val TT_INT	    = "INT"
val TT_FLOAT    = "FLOAT"
val TT_PLUS     = "PLUS"
val TT_MINUS    = "MINUS"
val TT_MUL      = "MUL"
val TT_DIV      = "DIV"
val TT_LPAREN   = "LPAREN"
val TT_RPAREN   = "RPAREN"

class Lexer(val fn: String, val text: String, val pos: Position = Position(-1, 0, -1, fn, text), var current_char: Char? = null) {

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

    fun make_tokens() {
        var tokens: Array<Token> = emptyArray()

        // TODO: Finish function here and clean up some code.
    }
}