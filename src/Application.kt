package com.restApiCrud

import com.fasterxml.jackson.databind.SerializationFeature
import com.restApiCrud.controllers.EmployeeController
import com.restApiCrud.controllers.HomeController
import com.restApiCrud.dbConfig.initDB
import com.restApiCrud.services.EmployeeService
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.routing.*
import io.ktor.util.*

fun main(args: Array<String>): Unit = io.ktor.server.tomcat.EngineMain.main(args)

@KtorExperimentalAPI
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    initDB()
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        HomeController().apply {
            home()
        }

        EmployeeController(EmployeeService()).apply {
            init()
        }
    }
}

