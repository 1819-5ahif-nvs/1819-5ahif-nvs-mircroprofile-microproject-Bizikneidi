package sample

import entity.Car
import persistence.CarRepository
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cars")
class CarEndpoint {
    @Inject
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