package com.restApiCrud.controllers

import com.restApiCrud.dtos.EmployeeRequestDTO
import com.restApiCrud.dtos.ResponseDTO
import com.restApiCrud.services.EmployeeService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

class EmployeeController(var employeeService: EmployeeService) {

    fun Route.init() {
        route("/employees") {
            post("/") {
                val employeeRequestDTO = call.receive<EmployeeRequestDTO>()
                var responseDTO: ResponseDTO<String> = ResponseDTO()
                employeeService.addEmployee(employeeRequestDTO)
                responseDTO.setSuccessResponse("Employee ${employeeRequestDTO.name} has been saved successfully")
                call.respond(HttpStatusCode.OK, responseDTO)
            }
        }
    }
}
