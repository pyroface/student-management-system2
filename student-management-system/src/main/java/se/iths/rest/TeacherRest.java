package se.iths.rest;

import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("new")
    @POST
    public Response createTeacher(Teacher teacher){
        teacherService.createTeacher(teacher);
        return Response.ok(teacher).build();
    }

    @Path("update")
    @PUT
    public Response updateTeacher(Teacher teacher){
        teacherService.updateTeacher(teacher);
        return Response.ok(teacher).build();
    }

    @Path("{id}")
    @GET
    public Response getTeacher(@PathParam("id") Long id){
        Teacher foundTeacher = teacherService.findTeacherById(id);
        return Response.ok(foundTeacher).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id){
        teacherService.deleteTeacher(id);
        return Response.ok().build();
    }
}
