package at.htl.nvs.kneidinger.microprofilekneidinger.endpoints

import at.htl.nvs.kneidinger.microprofilekneidinger.entity.Car
import at.htl.nvs.kneidinger.microprofilekneidinger.persistence.CarRepository
import javax.ejb.EJB
import javax.faces.bean.RequestScoped
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cars")
@RequestScoped
class CarEndpoint {
    @EJB
    private var repository: CarRepository? = null

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll() = Response.ok(repository?.getAll()).build()!!

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getById(@PathParam("id") id: Long) = Response.ok(repository?.getById(id)).build()!!

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun create(c: Car) = Response.ok(repository?.create(c)).build()!!

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    fun update(c: Car) = Response.ok(repository?.update(c)).build()!!

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: Long) = Response.ok(repository?.delete(id)).build()!!

}