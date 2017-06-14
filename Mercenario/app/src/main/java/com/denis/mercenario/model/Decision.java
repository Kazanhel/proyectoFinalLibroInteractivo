package com.denis.mercenario.model;


public class Decision {
    private int textoDecisionId;
    private int siguientePagina;
    private  String habilidadCondicion;
    private int paginaHabilidadCondicion;

    public Decision(int textoDecisionId, int siguientePagina,String habilidadCondicion) {
        this.textoDecisionId = textoDecisionId;
        this.siguientePagina = siguientePagina;
        this.habilidadCondicion = habilidadCondicion;
    }
    public Decision(int textoDecisionId, int siguientePagina) {
        this.textoDecisionId = textoDecisionId;
        this.siguientePagina = siguientePagina;
        this.habilidadCondicion = "";
    }

    public int getTextoDecisionId() {
        return textoDecisionId;
    }

    public void setTextoDecisionId(int textoDecisionId) {
        this.textoDecisionId = textoDecisionId;
    }

    public int getSiguientePagina() {
        return siguientePagina;
    }

    public void setSiguientePagina(int siguientePagina) {
        this.siguientePagina = siguientePagina;
    }

    public boolean isBotonVisible(String habildadEscogida){
        if(habildadEscogida.equals(getHabilidadCondicion())||getHabilidadCondicion().equals("")){
            return true;
        }
        else{
            return false;
        }
    }

    public String getHabilidadCondicion() {
        return habilidadCondicion;
    }

    public void setHabilidadCondicion(String habilidadCondicion) {
        this.habilidadCondicion = habilidadCondicion;
    }
}
