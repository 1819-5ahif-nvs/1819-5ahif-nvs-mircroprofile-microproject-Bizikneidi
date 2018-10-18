package at.htl.nvs.kneidinger.microprofilekneidinger.endpoints

import at.htl.nvs.kneidinger.microprofilekneidinger.entity.Person
import at.htl.nvs.kneidinger.microprofilekneidinger.persistence.PersonRepository
import javax.ejb.EJB
import javax.faces.bean.RequestScoped
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/people")
@RequestScoped
class PersonEndpoint {
    @EJB
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