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
                              @FormParam("tipo")String max,
                              @FormParam("restricoes") List<String> T
    ){
        for(int i=0;i<T.size();i++){
            System.out.println(T.get(i));
        }

        if( fx.length()>0)
        {
            String[] fo=Change.deleteEmpty(fx.split("[^\\d|-]"));
            TreeMap<Integer,BigDecimal[]> lines = new TreeMap<Integer, BigDecimal[]>();
            BigDecimal [] Fx=new BigDecimal[]{} ;
            for (int i=(fo.length-1);i>=0;i--){
                if(max!=null && i<(fo.length-1)) {
                    Fx = Change.toGheter(new BigDecimal[]{new BigDecimal(0).subtract( new BigDecimal(Integer.parseInt(fo[i])))}, Fx);
                }else{
                    Fx = Change.toGheter(new BigDecimal[]{new BigDecimal(Integer.parseInt(fo[i]))}, Fx);
                }
            }
            lines.put(0,Fx);
            for(int i=0;i<T.size();i++){
                String[] restriction=Change.deleteEmpty(T.get(i).split("[^0-9|-]"));
                BigDecimal [] x=new BigDecimal[]{null} ;
                for (int j=(restriction.length-1);j>=0;j--){
                    if(max!=null && j<(fo.length-1)) {
                        x = Change.toGheter(new BigDecimal[]{new BigDecimal(0).subtract( new BigDecimal(Integer.parseInt(restriction[j])))}, x);
                    }else{
                        x = Change.toGheter(new BigDecimal[]{new BigDecimal(Integer.parseInt(restriction[j]))}, x);
                    }
                }
                lines.put(i+1,x);
            }

            Fases W= new Fases();
            Table Aux= new Table(lines,Integer.parseInt(nbVarq));
            W.setMatrix(Aux.getMatrix(),Aux.getbVar(),Aux.getNbVar());
            SimplexExec.ExcFirst(W);
            String s="http://localhost:8080/response.jsp";
            return Response.created(URI.create(s)).build();
        }
        return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }

}
