package com.restApiCrud.services

import com.restApiCrud.domains.EmployeeEntity
import com.restApiCrud.dtos.EmployeeRequestDTO
import com.restApiCrud.dtos.EmployeeResponseDTO
import org.jetbrains.exposed.sql.transactions.transaction

class EmployeeService {

    fun addEmployee(employeeRequestDTO: EmployeeRequestDTO) {
        transaction {
            EmployeeEntity.new {
                this.name = employeeRequestDTO.name
                this.salary = employeeRequestDTO.salary
            }
        }
    }

    fun fetchEmployeeList(): List<EmployeeResponseDTO> {
        var employeeListDTO: List<EmployeeResponseDTO> = arrayListOf()
        transaction {
            val employeeList = EmployeeEntity.all()
            employeeListDTO = employeeList.map { EmployeeResponseDTO(it) }.toList()
        }
        return employeeListDTO
    }
}