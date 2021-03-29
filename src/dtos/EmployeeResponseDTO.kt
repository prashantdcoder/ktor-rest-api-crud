package com.restApiCrud.dtos

import com.restApiCrud.domains.EmployeeEntity

class EmployeeResponseDTO(employeeEntity: EmployeeEntity) {

    var id: Int? = null
    var name: String? = null
    var salary: Long? = null

    init {
        this.id = employeeEntity.id.value
        this.name = employeeEntity.name
        this.salary = employeeEntity.salary
    }

}