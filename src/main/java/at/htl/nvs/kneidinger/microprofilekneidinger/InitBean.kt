package at.htl.nvs.kneidinger.microprofilekneidinger

import at.htl.nvs.kneidinger.microprofilekneidinger.entity.Car
import at.htl.nvs.kneidinger.microprofilekneidinger.entity.Person
import at.htl.nvs.kneidinger.microprofilekneidinger.persistence.CarRepository
import javax.annotation.PostConstruct
import javax.ejb.EJB
import javax.ejb.Singleton
import javax.ejb.Startup
import javax.inject.Inject

@Startup
@Singleton
open class InitBean {
    @EJB
    open lateinit var carRepository: CarRepository

    @PostConstruct
    fun init() {
        carRepository.create(Car(brand = "Audi", type = "A6", owners = listOf(
                Person(name = "Bürgi"),
                Person(name = "Bizi")
        )))
        carRepository.create(Car(brand = "Audi", type = "RS8", owners = listOf(
                Person(name = "Bizi")
        )))
    }

}