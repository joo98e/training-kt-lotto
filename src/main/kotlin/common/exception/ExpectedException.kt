package common.exception

class ExpectedException : RuntimeException {
    constructor() : super() {}
    constructor(message: String?) : super("[ERROR]: $message") {}
}