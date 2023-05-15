package view.exception

class ReadlineFormatException : NumberFormatException {
    constructor() : super() {}
    constructor(message: String?) : super("[ERROR]: $message") {}
}