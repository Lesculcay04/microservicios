package com.example.students.model

import jakarta.persistence.*

@Entity
@Table(name = "student")
class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombres: String? = null
    var direccion: String? = null
    var apellidos: String? = null
    var nui: String? = null
    var telefono: String? = null
}