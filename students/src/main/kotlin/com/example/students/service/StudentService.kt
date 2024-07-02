package com.example.students.service

import com.example.students.model.Student
import com.example.students.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class StudentService {
    @Autowired
    lateinit var studentRepository: StudentRepository


    fun list (pageable: Pageable,student:Student):Page<Student>{
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return studentRepository.findAll(Example.of(student, matcher), pageable)
    }

    fun save(student:Student): Student {
        try{
            student.nombres?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Nombres no debe ser vacio")
            student.direccion?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Direccion no debe ser vacio")

            return studentRepository.save(student)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Student?{
        return studentRepository.findById(id)
    }
}