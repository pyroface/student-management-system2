package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    //CREATE
    @Path("new")
    @POST
    public Response createStudent(Student student){
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    //READ
    @Path("{id}")
    @GET
    public Response getStudentById(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("No student with ID: " + id + " was found.").type(MediaType.TEXT_PLAIN_TYPE).build());
        }
        return Response.ok(foundStudent).build();
    }

    @Path("getbylastname/{lastName}")
    @GET
    public List<Student> getByLastName(@PathParam("lastName") String lastName) {
        return studentService.getByLastnameQuery(lastName);
    }

    //UPDATE
    @Path("update")
    @PUT
    public Response updateStudent(Student student){

        studentService.updateStudent(student);
        return Response.ok(student).build();

    }

    //DELETE
    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id){
        studentService.deleteStudent(id);
        return Response.ok().build();
    }

}
