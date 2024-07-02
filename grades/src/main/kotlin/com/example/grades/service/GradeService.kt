package com.example.grades.service

import com.example.grades.model.Grade
import com.example.grades.repository.GradeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class GradeService {
    @Autowired
    private lateinit var gradeRepository: GradeRepository


    fun list (pageable: Pageable, grade:Grade): Page<Grade> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return gradeRepository.findAll(Example.of(grade, matcher), pageable)
    }

    fun save(grade:Grade): Grade {
        try{
            grade.grade?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("grados no debe ser vacio")
            grade.subject?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Materia no debe ser vacio")

            return gradeRepository.save(grade)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Grade?{
        return gradeRepository.findById(id)
    }
}