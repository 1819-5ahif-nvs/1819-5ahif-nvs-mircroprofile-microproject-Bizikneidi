package at.htl.nvs.kneidinger.microprofilekneidinger.persistence

import at.htl.nvs.kneidinger.microprofilekneidinger.entity.Car
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Stateless
open class CarRepository: Repository<Car> {
    @PersistenceContext
    private var entityManager: EntityManager? = null

    override fun create(item: Car): Car {
        entityManager!!.persist(item)
        return item
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