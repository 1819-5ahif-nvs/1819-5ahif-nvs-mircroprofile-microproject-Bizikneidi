package endpoints

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
data class Car (
        var id: Long? = null,
        var brand: String? = null,
        var type: String? = null,
        @Column(name = "OWNERS")
        @OneToMany(cascade = [CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST])
        var owners: List<Person>? = null
)