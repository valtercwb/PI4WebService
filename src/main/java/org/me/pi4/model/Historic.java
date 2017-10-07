package org.me.pi4.model;

/**
 * @author 2016203311
 */
public class Historic {

    private int historicId;
    private boolean hiv;
    private boolean sifilis;
    private boolean gonorreia;
    private boolean clamidia;
    private boolean diabetes;
    private boolean doencaMental;
    private boolean anomalia;
    private boolean neoplasia;
    private boolean tromboembo;
    private boolean cardiopatia;
     
    public Historic() {
    }

    public int getHistoricId() {
        return historicId;
    }

    public void setHistoricId(int historicId) {
        this.historicId = historicId;
    }

    public boolean isHiv() {
        return hiv;
    }

    public void setHiv(boolean hiv) {
        this.hiv = hiv;
    }

    public boolean isSifilis() {
        return sifilis;
    }

    public void setSifilis(boolean sifilis) {
        this.sifilis = sifilis;
    }

    public boolean isGonorreia() {
        return gonorreia;
    }

    public void setGonorreia(boolean gonorreia) {
        this.gonorreia = gonorreia;
    }

    public boolean isClamidia() {
        return clamidia;
    }

    public void setClamidia(boolean clamidia) {
        this.clamidia = clamidia;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isDoencaMental() {
        return doencaMental;
    }

    public void setDoencaMental(boolean doencaMental) {
        this.doencaMental = doencaMental;
    }

    public boolean isAnomalia() {
        return anomalia;
    }

    public void setAnomalia(boolean anomalia) {
        this.anomalia = anomalia;
    }

    public boolean isNeoplasia() {
        return neoplasia;
    }

    public void setNeoplasia(boolean neoplasia) {
        this.neoplasia = neoplasia;
    }

    public boolean isTromboembo() {
        return tromboembo;
    }

    public void setTromboembo(boolean tromboembo) {
        this.tromboembo = tromboembo;
    }

    public boolean isCardiopatia() {
        return cardiopatia;
    }

    public void setCardiopatia(boolean cardiopatia) {
        this.cardiopatia = cardiopatia;
    }
        
}
