package retrofit.com.newskh.model;

import com.google.gson.annotations.SerializedName;


public class AnArticleResponse {

    @SerializedName("MESSAGE")
    private String mESSAGE;

    @SerializedName("CODE")
    private String cODE;

    @SerializedName("DATA")
    private DATAItem dATA;

    public String getmESSAGE() {
        return mESSAGE;
    }

    public void setmESSAGE(String mESSAGE) {
        this.mESSAGE = mESSAGE;
    }

    public String getcODE() {
        return cODE;
    }

    public void setcODE(String cODE) {
        this.cODE = cODE;
    }

    public DATAItem getdATA() {
        return dATA;
    }

    public void setdATA(DATAItem dATA) {
        this.dATA = dATA;
    }

    @Override
    public String toString() {
        return "AnArticleResponse{" +
                "mESSAGE='" + mESSAGE + '\'' +
                ", cODE='" + cODE + '\'' +
                ", dATA=" + dATA +
                '}';
    }
}