package com.denis.mercenario.model;


public class Pagina {
    private int textoId;
    private Decision decision1;
    private Decision decision2;
    private Decision decision3;
    private boolean isPaginaFinal = false;

    public Pagina(int textoId) {
        this.textoId = textoId;
        this.isPaginaFinal = true;
    }

    public Pagina(int textoId, Decision decision1, Decision decision2, Decision decision3) {
        this.textoId = textoId;
        this.decision1 = decision1;
        this.decision2 = decision2;
        this.decision3 = decision3;
    }

    public int getTextoId() {
        return textoId;
    }

    public void setTextoId(int textoId) {
        this.textoId = textoId;
    }

    public Decision getDecision1() {
        return decision1;
    }

    public void setDecision1(Decision decision1) {
        this.decision1 = decision1;
    }

    public Decision getDecision2() {
        return decision2;
    }

    public void setDecision2(Decision decision2) {
        this.decision2 = decision2;
    }

    public Decision getDecision3() {
        return decision3;
    }

    public void setDecision3(Decision decision3) {
        this.decision3 = decision3;
    }

    public boolean isPaginaFinal() {
        return isPaginaFinal;
    }

    public void setPaginaFinal(boolean paginaFinal) {
        isPaginaFinal = paginaFinal;
    }

    public boolean hasOpcionEspecialPagina(String habilidadEscogida){
        if(getDecision1().isBotonVisible(habilidadEscogida) && getDecision2().isBotonVisible(habilidadEscogida) && getDecision3().isBotonVisible(habilidadEscogida)){
            return true;
        }
        else{
            return false;
        }
    }
}
