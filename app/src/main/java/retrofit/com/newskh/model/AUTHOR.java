package retrofit.com.newskh.model;

import com.google.gson.annotations.SerializedName;

public class AUTHOR {

    @SerializedName("TELEPHONE")
    private Object tELEPHONE;

    @SerializedName("STATUS")
    private Object sTATUS;

    @SerializedName("GENDER")
    private Object gENDER;

    @SerializedName("ID")
    private int iD;

    @SerializedName("FACEBOOK_ID")
    private Object fACEBOOKID;

    @SerializedName("EMAIL")
    private Object eMAIL;

    @SerializedName("NAME")
    private Object nAME;

    @SerializedName("IMAGE_URL")
    private Object iMAGEURL;

    public void setTELEPHONE(Object tELEPHONE) {
        this.tELEPHONE = tELEPHONE;
    }

    public Object getTELEPHONE() {
        return tELEPHONE;
    }

    public void setSTATUS(Object sTATUS) {
        this.sTATUS = sTATUS;
    }

    public Object getSTATUS() {
        return sTATUS;
    }

    public void setGENDER(Object gENDER) {
        this.gENDER = gENDER;
    }

    public Object getGENDER() {
        return gENDER;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public int getID() {
        return iD;
    }

    public void setFACEBOOKID(Object fACEBOOKID) {
        this.fACEBOOKID = fACEBOOKID;
    }

    public Object getFACEBOOKID() {
        return fACEBOOKID;
    }

    public void setEMAIL(Object eMAIL) {
        this.eMAIL = eMAIL;
    }

    public Object getEMAIL() {
        return eMAIL;
    }

    public void setNAME(Object nAME) {
        this.nAME = nAME;
    }

    public Object getNAME() {
        return nAME;
    }

    public void setIMAGEURL(Object iMAGEURL) {
        this.iMAGEURL = iMAGEURL;
    }

    public Object getIMAGEURL() {
        return iMAGEURL;
    }

    @Override
    public String toString() {
        return
                "AUTHOR{" +
                        "tELEPHONE = '" + tELEPHONE + '\'' +
                        ",sTATUS = '" + sTATUS + '\'' +
                        ",gENDER = '" + gENDER + '\'' +
                        ",iD = '" + iD + '\'' +
                        ",fACEBOOK_ID = '" + fACEBOOKID + '\'' +
                        ",eMAIL = '" + eMAIL + '\'' +
                        ",nAME = '" + nAME + '\'' +
                        ",iMAGE_URL = '" + iMAGEURL + '\'' +
                        "}";
    }
}