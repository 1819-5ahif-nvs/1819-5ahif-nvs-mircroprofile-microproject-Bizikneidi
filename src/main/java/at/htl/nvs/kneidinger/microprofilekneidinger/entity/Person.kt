package at.htl.nvs.kneidinger.microprofilekneidinger.entity

import javax.persistence.Entity
import javax.persistence.NamedQuery

@Entity
@NamedQuery(name = "Person.getAll", query = "SELECT p FROM Person p")
data class Person (
        var id: Long,
        var name: String
)