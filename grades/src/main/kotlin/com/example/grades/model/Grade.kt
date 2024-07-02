package com.example.grades.model

import jakarta.persistence.*

@Entity
@Table(name = "grades")
class Grade {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var subject: String? = null
    var note: Number? = null
    var grade: String? = null
}