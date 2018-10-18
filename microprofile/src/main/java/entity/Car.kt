package entity

import javax.persistence.*

@Entity
@NamedQuery(name = "Car.getAll", query = "SELECT c FROM Car c")
data class Car (
        var id: Long? = null,
        var brand: String? = null,
        var type: String? = null,
        @Column(name = "OWNERS")
        @OneToMany(cascade = [CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST])
        var owners: List<Person>? = null
)