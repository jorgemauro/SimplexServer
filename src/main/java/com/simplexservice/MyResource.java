package com.simplexservice;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("myresource")
public class MyResource {
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createMsg(@FormParam("funcoes") String fx, @FormParam("restricao") String nbVarq){
        if( nbVarq.length()>0 && fx.length()>0)

        {

            System.out.println(fx);
            System.out.println(nbVarq);
            Response.created(URI.create("/"+fx));
        }
        return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }

}
