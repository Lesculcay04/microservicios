package com.example.students.repository

import com.example.students.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student, Long?> {
    fun findById (id: Long?): Student?
}