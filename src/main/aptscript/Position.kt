class Position(var idx: Int, var ln: Int, var col: Int, val fn: String, val ftext: String) {
    fun advance(current_char: Char) {
        this.idx += 1
        this.col += 1

        if (current_char == '\n') {
            this.ln += 1
            this.col = 0
        }
    }

    fun copy(): Position {
        return Position(this.idx, this.ln, this.col, this.fn, this.ftext)
    }
}