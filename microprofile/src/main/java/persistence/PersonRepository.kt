package persistence

import entity.Person
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Stateless
class PersonRepository: Repository<Person> {
    @PersistenceContext
    var entityManager: EntityManager? = null

    override fun create(item: Person) {
        entityManager!!.persist(item)
    }

    override fun update(item: Person) {
        entityManager!!.merge(item)
    }

    override fun getAll(): List<Person> {
        return entityManager!!.createNamedQuery("Person.getAll", Person::class.java).resultList
    }

    override fun getById(id: Long): Person {
        return entityManager!!.find(Person::class.java, id)
    }

    override fun delete(id: Long) {
        entityManager!!.remove(id)
    }

}