class Token(val type: String, var value: Any? = null) {
    override fun toString(): String {
        if (this.value is Int || this.value is Float) {
            return "${this.type}:${this.value}"
        }
        return "$this.type"
    }
}