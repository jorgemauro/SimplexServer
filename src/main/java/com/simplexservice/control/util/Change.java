package com.simplexservice.control.util;

import com.simplexservice.control.Cell;
import com.simplexservice.control.Table;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public final class Change {

    public  static BigDecimal Inverse(BigDecimal val){
        BigDecimal Ans;
        BigDecimal one=new BigDecimal(1);
        Ans = one.divide(val,4, RoundingMode.HALF_UP);

        return Ans;
    }

    public static boolean signalComp(BigDecimal val1, BigDecimal val2){
        if(val1.signum()<0&&val2.signum()<0){
            return true;
        }else if(val1.signum()>0&&val2.signum()>0){
            return true;
        }else if(val1.signum()==0&&val2.signum()==0){
            return true;
        }
        return false;
    }
    public static void PrintCell(Cell C){
        System.out.print(" Sup : "+ C.getCellSup()+ "/ inf: "+ C.getCellInf()+ " " );
    }
    public static void PrintTable(Table T){
        for (int i=0;i< T.getMatrix().length;i++){
            for(int j=0;j<T.getMatrix()[1].length;j++){
                PrintCell(T.getMatrix()[i][j]);
            }
            System.out.println(" ");
        }
    }
    public static String[] deleteEmpty(String[]empty){

        int count=0;
        for(int i=0;i<empty.length;i++){
            if(!empty[i].equals("")){
                count++;
            }
        }

        String[] aux= new String[count];
        count=0;
        for(int i=0;i<empty.length;i++){
            if(!empty[i].equals("")){
                aux[count]=empty[i];
                count++;
            }
        }
        return aux;
    }
}
