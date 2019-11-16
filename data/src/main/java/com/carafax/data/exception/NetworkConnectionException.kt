package com.carafax.data.exception

import java.lang.Exception

class NetworkConnectionException : Exception {
    constructor(message: String): super(message)
    constructor(): super()
}