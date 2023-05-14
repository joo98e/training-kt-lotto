package common.exception

open class ExpectedException : RuntimeException {
    constructor() : super() {}
    constructor(message: String?) : super("[ERROR]: $message") {}
}