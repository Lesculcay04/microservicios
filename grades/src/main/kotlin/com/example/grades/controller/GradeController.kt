package com.example.grades.controller

import com.example.grades.model.Grade
import com.example.grades.service.GradeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/grades")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class GradeController {
    @Autowired
    lateinit var gradeService: GradeService

    @GetMapping
    fun list():String{
        return "grados"
    }
//@RequestParam searchValue:String

    @PostMapping
    fun save (@RequestBody grade: Grade): ResponseEntity<Grade> {
        return ResponseEntity(gradeService.save(grade), HttpStatus.OK )
    }
}