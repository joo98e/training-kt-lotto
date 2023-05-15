package view.exception

class ReadlineNotIntegerException : NumberFormatException {
    constructor() : super() {}
    constructor(message: String?) : super("[ERROR]: $message") {}
}
