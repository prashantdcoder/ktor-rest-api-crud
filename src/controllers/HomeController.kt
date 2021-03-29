package com.restApiCrud.controllers

import com.restApiCrud.dtos.ResponseDTO
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

class HomeController {
    fun Route.home() {
        route("/home") {
            get("/") {
                val responseDTO: ResponseDTO<String> = ResponseDTO()
                responseDTO.setSuccessResponse("Welcome to the world of Kotlin and Ktor")
                call.respond(status = HttpStatusCode.OK, message = responseDTO)
            }
        }
    }
}