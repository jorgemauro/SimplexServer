package com.simplexservice.control;

import java.math.BigDecimal;

/**
 * Estrutura da celula da matriz
 * 
 **/ 
public class Cell {

    private Boolean AceptCell;
    private Boolean ChkCellSup;
    private Boolean ChkCellInf;
    private BigDecimal CellSup;
    private BigDecimal CellInf;

	
	/**
	 * Construtor que inicializa todos os atributos da celula.
	 * */
    public Cell(BigDecimal CellSup,BigDecimal CellInf){
		this.CellSup=CellSup;
		this.CellInf=CellInf;
		this.ChkCellInf= false;
		this.ChkCellSup=false;
		this.AceptCell=false;
    }
    
    
    /**
     * Construtor padrao.
     * */
    public Cell(){
        this.ChkCellInf= false;
        this.ChkCellSup=false;
        this.AceptCell=false;
    }
    
    
    /**
     * Verifica celulas.
     * */
    public Boolean isAceptCell() {
        return AceptCell;
    }


    public Boolean isChkCellInf() {
        return ChkCellInf;
    }


    public Boolean isChkCellSup() {
        return ChkCellSup;
    }
    
/** Getters and Setters */
    public BigDecimal getCellInf() {
        return CellInf;
    }

    public BigDecimal getCellSup() {
        return CellSup;
    }
    
    public void setAceptCell(Boolean aceptCell) {

    }

    public void setCellInf(BigDecimal cellInf) {
        CellInf = cellInf;
    }

    public void setCellSup(BigDecimal cellSup) {
        CellSup = cellSup;
    }

    public void setChkCellInf(Boolean chkCellInf) {
        ChkCellInf = chkCellInf;
    }

    public void setChkCellSup(Boolean chkCellSup) {
        ChkCellSup = chkCellSup;
    }
}
