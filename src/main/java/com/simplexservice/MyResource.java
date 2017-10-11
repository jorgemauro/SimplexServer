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
                              @FormParam("tipo")String max,
                              @FormParam("restricoes") List<String> T
                              ){

        int nbVarq=T.size();
        for(int i=0;i<T.size();i++){
            System.out.println(T.get(i));
        }

        if( fx.length()>0)
        {
        String[] fo=Change.deleteEmpty(fx.split("[^\\d|-]"));
        TreeMap<Integer,BigDecimal[]> lines = new TreeMap<Integer, BigDecimal[]>();
        BigDecimal [] Fx=new BigDecimal[fo.length];
        int tamanho=fo.length-1;
        for (int i=tamanho;i>=0;i--){
         try {
                if (max != null && i < (fo.length - 1)) {
                    Fx[tamanho - i] = new BigDecimal(Float.parseFloat(fo[i]));
                } else {
                    Fx[tamanho - i] = new BigDecimal(Float.parseFloat(fo[i]));
                }
            }catch (Exception e){
             System.out.println(e);
         }
        }
        lines.put(0,Fx);
        for(int i=0;i<T.size();i++){
                String[] restriction=Change.deleteEmpty(T.get(i).split("[^0-9|-]"));
            BigDecimal [] x=new BigDecimal[restriction.length];
            tamanho=x.length-1;
                for (int j=(restriction.length-1);j>=0;j--){
                        if(max!=null && j<(fo.length-1)) {
                            x[tamanho - j] = new BigDecimal(0).subtract( new BigDecimal(Integer.parseInt(restriction[j])));
                        }else{
                            x[tamanho - j] = new BigDecimal(Integer.parseInt(restriction[j]));
                        }
                }
                lines.put(i+1,x);
        }

            Fases W= new Fases();
            Table Aux= new Table(lines,nbVarq);
            W.setMatrix(Aux.getMatrix(),Aux.getbVar(),Aux.getNbVar());
            Change.PrintTable(W);
            SimplexExec.ExcFirst(W);
            String s="http://localhost:8080/response.jsp";
            return Response.created(URI.create(s)).build();
        }
        return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }

}
