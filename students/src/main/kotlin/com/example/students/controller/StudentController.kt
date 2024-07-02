package com.example.students.controller
import com.example.students.model.Student
import com.example.students.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/students")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class StudentController {

    @Autowired
    lateinit var studentService: StudentService
    @GetMapping
    fun list():String{
        return "estudiantes"
    }
//@RequestParam searchValue:String

    @PostMapping
    fun save (@RequestBody student: Student): ResponseEntity<Student> {
        return ResponseEntity(studentService.save(student), HttpStatus.OK )
    }
}