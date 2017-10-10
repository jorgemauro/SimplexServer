package com.simplexservice;
import com.simplexservice.control.Fases;
import com.simplexservice.control.SimplexExec;
import com.simplexservice.control.Table;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.net.URI;
import java.util.TreeMap;

@Path("myresource")
public class MyResource {
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createMsg(@FormParam("funcoes") String fx, @FormParam("restricao") String nbVarq){
        System.out.println(fx);
        System.out.println(nbVarq);
        if( nbVarq.length()>0 && fx.length()>0)

        {
            TreeMap<Integer,BigDecimal[]> lines = new TreeMap<Integer, BigDecimal[]>();
            BigDecimal[] Fx= new BigDecimal[]{new BigDecimal(0), new BigDecimal(80),new BigDecimal(60)};
            BigDecimal[] x3= new BigDecimal[]{new BigDecimal(-24), new BigDecimal(-4),new BigDecimal(-6)};
            BigDecimal[] x4= new BigDecimal[]{new BigDecimal(16), new BigDecimal(4),new BigDecimal(2)};
            BigDecimal[] x5= new BigDecimal[]{new BigDecimal(3), new BigDecimal(0),new BigDecimal(1)};

            lines.put(0,Fx);
            lines.put(2,x4);
            lines.put(3,x5);
            lines.put(1,x3);

            Fases T= new Fases();
            Table Aux= new Table(lines,3);
            T.setMatrix(Aux.getMatrix(),Aux.getbVar(),Aux.getNbVar());
            SimplexExec.ExcFirst(T);
            return Response.created(URI.create("/"+fx)).build();
        }
        return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }

}
