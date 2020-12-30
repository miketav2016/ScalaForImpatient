package ch19AdvancedTypes.s10SelfTypes

trait Logger10 {
    def log(msg: String)
}

trait LoggedException extends Logger10 {
    this: Exception =>
    def log() {
        log(getMessage())
    } // OK to call getMessage because this is an Exception
}