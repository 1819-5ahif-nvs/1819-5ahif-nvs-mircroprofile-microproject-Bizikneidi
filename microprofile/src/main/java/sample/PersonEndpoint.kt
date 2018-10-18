package sample

import entity.Person
import persistence.PersonRepository
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cars")
class PersonEndpoint {
    @Inject
    private var repository: PersonRepository? = null

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll() = Response.ok(repository?.getAll()).build()!!

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getById(@PathParam("id") id: Long) = Response.ok(repository?.getById(id)).build()!!

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun create(person: Person) = Response.ok(repository?.create(person)).build()!!

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    fun update(person: Person) = Response.ok(repository?.update(person)).build()!!

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: Long) = Response.ok(repository?.delete(id)).build()!!

}