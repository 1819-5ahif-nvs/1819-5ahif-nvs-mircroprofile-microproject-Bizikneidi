package endpoints

import javax.persistence.Entity

@Entity
data class Person (
        var id: Long,
        var name: String
)