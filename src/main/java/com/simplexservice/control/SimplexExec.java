package com.simplexservice.control;

import com.simplexservice.control.util.Change;

import java.math.BigDecimal;

/**
 * Execucao do Simplex.
 * */
public class SimplexExec {
    Fases T;


	/**
	 * Construtor padrao que inicializa o atributo T do tipo Fases.
	 * */		
	public SimplexExec(){
        this.T=new Fases();
    }


	/**
	 * Inicializa a execucao do Simplex.
	 * @param T - Objeto do tipo Fases a ser processado.
	 * */
    public static void ExcFirst(Fases T){
        int colAccept=0;
        int lineAccept=0;
        int TheLine=0;

		lineAccept=T.firstDotOne();
		if(lineAccept>0){
			colAccept=T.firstDotTwo(lineAccept);
			if(colAccept>0){
				TheLine=T.firstDotThree(colAccept);
				System.out.println("fim primeira fase");
				Change.PrintTable(T);
				System.out.println("--------------------------------------------------------------------");

				SimplexExec.ChangeExec(TheLine,colAccept,T);

			}else{
				System.out.println("Sem solução");
				Change.PrintTable(T);
				System.out.println("--------------------------------------------------------------------");
				System.out.println("Sem solução");
			}
		}else{
			SimplexExec.ExcSecond(T);
		}

    }
    
    
    /**
     * Execucao da primeira fase.
     * @param TheLine - inteiro indicando a linha a ser processada.
     * @param colAccept - inteiro indicando a coluna.
	 * @param T - Objeto do tipo Fases a ser manipulado. 
     * */
    public static void ChangeExec(int TheLine,int colAccept, Fases T ){
        Fases NewT;
        Cell cellAccept=T.getMatrix()[TheLine][colAccept];
        BigDecimal invCellAccept= Change.Inverse(cellAccept.getCellSup());
        cellAccept.setCellInf(invCellAccept);
        T.mulLineInverse(TheLine,invCellAccept);
        T.mulColInverse(colAccept,invCellAccept);
        T.chkCellLineSup(TheLine);
        T.chkCellColInf(colAccept);
        T.mulSupInf();
        NewT=T.changePostion(TheLine,colAccept);
        NewT.infForSup(colAccept,TheLine);
        NewT.SumNotSupAndInf(T,colAccept,TheLine);

        if(NewT.MlNegative()){
            ExcFirst(NewT);
        }else {
            ExcSecond(NewT);
        }
    }


	/**
	 * Execucao da segunda fase.
	 * @param T - Objeto do tipo Fases a ser manipulado.
	 * */
    private static void ExcSecond(Fases T) {
        int colAccept=0;
        int lineAccept=0;
        int TheLine=0;

        lineAccept=T.secondDotOne();
        if(lineAccept>0){
            colAccept=T.secondDotTwo(lineAccept);
            if(colAccept>0){
                TheLine=T.SecondDotThree(colAccept);
                SimplexExec.ChangeExec(TheLine,colAccept,T);

            }else{
                System.out.println("não existe solução");
            }
        }else{
            System.out.println("Solução encontrada");
            System.out.println("fim segunda");
            Change.PrintTable(T);
            System.out.println("--------------------------------------------------------------------");
        }
    }
}
