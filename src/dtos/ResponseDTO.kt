package com.restApiCrud.dtos

import kotlinx.serialization.Serializable

@Serializable
class ResponseDTO<T> {

    var status: Boolean = false
    var data: T? = null
    var message: String = ""

    fun setSuccessResponse(data: T) {
        this.status = true
        this.data = data
    }

    fun setFailureResponse(message: String) {
        this.status = false
        this.message = message
    }

}