package com.restApiCrud.services

import com.restApiCrud.domains.EmployeeEntity
import com.restApiCrud.dtos.EmployeeRequestDTO
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
}