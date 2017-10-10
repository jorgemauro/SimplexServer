package com.simplexservice;
import com.simplexservice.control.Fases;
import com.simplexservice.control.SimplexExec;
import com.simplexservice.control.Table;
import com.simplexservice.control.util.Change;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Path("myresource")
public class MyResource {
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMsg(@FormParam("funcoes") String fx,
                              @FormParam("n_restricao") String nbVarq,
                              @FormParam("maximizar")String max ){
        System.out.println(fx);
        System.out.println(max);
        System.out.println(nbVarq);

        if( fx.length()>0)
        {
        String[] fo=fx.split("[^0-9]");
        TreeMap<Integer,BigDecimal[]> lines = new TreeMap<Integer, BigDecimal[]>();
        BigDecimal [] Fx=new BigDecimal[]{null} ;

        for (int i=0;i<fo.length;i++){
            if(max!=null && i<(fo.length-1)) {
                Fx = Change.toGheter(new BigDecimal(0).subtract( new BigDecimal(fo[i])), Fx);
            }else{
                Fx = Change.toGheter(new BigDecimal(fo[i]), Fx);
            }
        }

            //Fases T= new Fases();
            //Table Aux= new Table(lines,Integer.parseInt(nbVarq));
            //T.setMatrix(Aux.getMatrix(),Aux.getbVar(),Aux.getNbVar());
            //SimplexExec.ExcFirst(T);
            String s="http://localhost:8080/response.jsp";
            return Response.created(URI.create(s)).build();
        }
        return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }

}
