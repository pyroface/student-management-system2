package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("new")
    @POST
    public Response createSubject(Subject subject) {
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("update")
    @PUT
    public Response updateSubject(Subject subject) {
        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("{id}")
    @GET
    public Response getSubject(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);

        if( foundSubject == null){
            throw new NotFoundException();
        }

        return Response.ok(foundSubject).build();
    }

    @Path("getall")
    @GET
    public Response getAllItems(){
        List<Subject> foundItems = subjectService.getAllSubjects();
        return Response.ok(foundItems).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteSubject(@PathParam("id") Long id) {
        subjectService.deleteSubject(id);
        return Response.ok().build();
    }
}
