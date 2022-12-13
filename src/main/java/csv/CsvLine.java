package csv;

import java.util.ArrayList;
import java.util.List;

public class CsvLine {

    private String umsatz;
    private String sollHabenKennzeichen;
    private String wkzUmsatz;
    private String kurs;
    private String basisumsatz;
    private String wkzBasisumsatz;
    private String konto;
    private String gegenkonto;
    private String buSchlüssel;
    private String belegDatum;
    private String belegfeld1;
    private String belegfeld2;
    private String skonto;
    private String buchungstext;
    private String postensperre;
    private String diverseAdressnummer;
    private String geschäftspartnerbank;
    private String sachverhalt;
    private String zinssperre;
    private String beleglink;
    private String beleginfoArt1;
    private String belefinfoInhalt1;
    private String beleginfoArt2;
    private String belefinfoInhalt2;
    private String beleginfoArt3;
    private String belefinfoInhalt3;
    private String beleginfoArt4;
    private String belefinfoInhalt4;
    private String beleginfoArt5;
    private String belefinfoInhalt5;
    private String beleginfoArt6;
    private String belefinfoInhalt6;
    private String beleginfoArt7;
    private String belefinfoInhalt7;
    private String beleginfoArt8;
    private String belefinfoInhalt8;

    public CsvLine() {

    }



    public String getUmsatz() {
        return umsatz;
    }

    public void setUmsatz(String umsatz) {
        this.umsatz = umsatz;
    }

    public String getSollHabenKennzeichen() {
        return sollHabenKennzeichen;
    }

    public void setSollHabenKennzeichen(String sollHabenKennzeichen) {
        this.sollHabenKennzeichen = sollHabenKennzeichen;
    }

    public String getWkzUmsatz() {
        return wkzUmsatz;
    }

    public void setWkzUmsatz(String wkzUmsatz) {
        this.wkzUmsatz = wkzUmsatz;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public String getBasisumsatz() {
        return basisumsatz;
    }

    public void setBasisumsatz(String basisumsatz) {
        this.basisumsatz = basisumsatz;
    }

    public String getWkzBasisumsatz() {
        return wkzBasisumsatz;
    }

    public void setWkzBasisumsatz(String wkzBasisumsatz) {
        this.wkzBasisumsatz = wkzBasisumsatz;
    }

    public String getKonto() {
        return konto;
    }

    public void setKonto(String konto) {
        this.konto = konto;
    }

    public String getGegenkonto() {
        return gegenkonto;
    }

    public void setGegenkonto(String gegenkonto) {
        this.gegenkonto = gegenkonto;
    }

    public String getBuSchlüssel() {
        return buSchlüssel;
    }

    public void setBuSchlüssel(String buSchlüssel) {
        this.buSchlüssel = buSchlüssel;
    }

    public String getBelegDatum() {
        return belegDatum;
    }

    public void setBelegDatum(String belegDatum) {
        this.belegDatum = belegDatum;
    }

    public String getBelegfeld1() {
        return belegfeld1;
    }

    public void setBelegfeld1(String belegfeld1) {
        this.belegfeld1 = belegfeld1;
    }

    public String getBelegfeld2() {
        return belegfeld2;
    }

    public void setBelegfeld2(String belegfeld2) {
        this.belegfeld2 = belegfeld2;
    }

    public String getSkonto() {
        return skonto;
    }

    public void setSkonto(String skonto) {
        this.skonto = skonto;
    }

    public String getBuchungstext() {
        return buchungstext;
    }

    public void setBuchungstext(String buchungstext) {
        this.buchungstext = buchungstext;
    }

    public String getPostensperre() {
        return postensperre;
    }

    public void setPostensperre(String postensperre) {
        this.postensperre = postensperre;
    }

    public String getDiverseAdressnummer() {
        return diverseAdressnummer;
    }

    public void setDiverseAdressnummer(String diverseAdressnummer) {
        this.diverseAdressnummer = diverseAdressnummer;
    }

    public String getGeschäftspartnerbank() {
        return geschäftspartnerbank;
    }

    public void setGeschäftspartnerbank(String geschäftspartnerbank) {
        this.geschäftspartnerbank = geschäftspartnerbank;
    }

    public String getSachverhalt() {
        return sachverhalt;
    }

    public void setSachverhalt(String sachverhalt) {
        this.sachverhalt = sachverhalt;
    }

    public String getZinssperre() {
        return zinssperre;
    }

    public void setZinssperre(String zinssperre) {
        this.zinssperre = zinssperre;
    }

    public String getBeleglink() {
        return beleglink;
    }

    public void setBeleglink(String beleglink) {
        this.beleglink = beleglink;
    }

    public String getBeleginfoArt1() {
        return beleginfoArt1;
    }

    public void setBeleginfoArt1(String beleginfoArt1) {
        this.beleginfoArt1 = beleginfoArt1;
    }

    public String getBelefinfoInhalt1() {
        return belefinfoInhalt1;
    }

    public void setBelefinfoInhalt1(String belefinfoInhalt1) {
        this.belefinfoInhalt1 = belefinfoInhalt1;
    }

    public String getBeleginfoArt2() {
        return beleginfoArt2;
    }

    public void setBeleginfoArt2(String beleginfoArt2) {
        this.beleginfoArt2 = beleginfoArt2;
    }

    public String getBelefinfoInhalt2() {
        return belefinfoInhalt2;
    }

    public void setBelefinfoInhalt2(String belefinfoInhalt2) {
        this.belefinfoInhalt2 = belefinfoInhalt2;
    }

    public String getBeleginfoArt3() {
        return beleginfoArt3;
    }

    public void setBeleginfoArt3(String beleginfoArt3) {
        this.beleginfoArt3 = beleginfoArt3;
    }

    public String getBelefinfoInhalt3() {
        return belefinfoInhalt3;
    }

    public void setBelefinfoInhalt3(String belefinfoInhalt3) {
        this.belefinfoInhalt3 = belefinfoInhalt3;
    }

    public String getBeleginfoArt4() {
        return beleginfoArt4;
    }

    public void setBeleginfoArt4(String beleginfoArt4) {
        this.beleginfoArt4 = beleginfoArt4;
    }

    public String getBelefinfoInhalt4() {
        return belefinfoInhalt4;
    }

    public void setBelefinfoInhalt4(String belefinfoInhalt4) {
        this.belefinfoInhalt4 = belefinfoInhalt4;
    }

    public String getBeleginfoArt5() {
        return beleginfoArt5;
    }

    public void setBeleginfoArt5(String beleginfoArt5) {
        this.beleginfoArt5 = beleginfoArt5;
    }

    public String getBelefinfoInhalt5() {
        return belefinfoInhalt5;
    }

    public void setBelefinfoInhalt5(String belefinfoInhalt5) {
        this.belefinfoInhalt5 = belefinfoInhalt5;
    }

    public String getBeleginfoArt6() {
        return beleginfoArt6;
    }

    public void setBeleginfoArt6(String beleginfoArt6) {
        this.beleginfoArt6 = beleginfoArt6;
    }

    public String getBelefinfoInhalt6() {
        return belefinfoInhalt6;
    }

    public void setBelefinfoInhalt6(String belefinfoInhalt6) {
        this.belefinfoInhalt6 = belefinfoInhalt6;
    }

    public String getBeleginfoArt7() {
        return beleginfoArt7;
    }

    public void setBeleginfoArt7(String beleginfoArt7) {
        this.beleginfoArt7 = beleginfoArt7;
    }

    public String getBelefinfoInhalt7() {
        return belefinfoInhalt7;
    }

    public void setBelefinfoInhalt7(String belefinfoInhalt7) {
        this.belefinfoInhalt7 = belefinfoInhalt7;
    }

    public String getBeleginfoArt8() {
        return beleginfoArt8;
    }

    public void setBeleginfoArt8(String beleginfoArt8) {
        this.beleginfoArt8 = beleginfoArt8;
    }

    public String getBelefinfoInhalt8() {
        return belefinfoInhalt8;
    }

    public void setBelefinfoInhalt8(String belefinfoInhalt8) {
        this.belefinfoInhalt8 = belefinfoInhalt8;
    }
}
