package com.restApiCrud.domains

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object EmployeeDomain : IntIdTable("employee") {
    var name = varchar("name", 255)
    var salary = long("salary")
}

class EmployeeEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<EmployeeEntity>(EmployeeDomain)

    var name by EmployeeDomain.name
    var salary by EmployeeDomain.salary

    fun toEmployee() = Employee(id.value, name, salary)
}

data class Employee(var id: Int, var name: String, var salary: Long)