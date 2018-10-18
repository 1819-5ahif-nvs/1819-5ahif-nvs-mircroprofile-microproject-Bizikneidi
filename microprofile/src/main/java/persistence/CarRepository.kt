package persistence

import entity.Car
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Stateless
class CarRepository: Repository<Car> {
    @PersistenceContext
    var entityManager: EntityManager? = null

    override fun create(item: Car) {
        entityManager!!.persist(item)
    }

    override fun update(item: Car) {
        entityManager!!.merge(item)
    }

    override fun getAll(): List<Car> {
        return entityManager!!.createNamedQuery("Car.getAll", Car::class.java).resultList
    }

    override fun getById(id: Long): Car {
        return entityManager!!.find(Car::class.java, id)
    }

    override fun delete(id: Long) {
        entityManager!!.remove(id)
    }

}