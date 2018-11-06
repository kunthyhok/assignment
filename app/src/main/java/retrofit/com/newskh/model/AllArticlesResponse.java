package retrofit.com.newskh.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class AllArticlesResponse {

    @SerializedName("MESSAGE")
    private String mESSAGE;

    @SerializedName("CODE")
    private String cODE;

    @SerializedName("DATA")
    private List<ArticleDataItem> dATA;

    @SerializedName("PAGINATION")
    private PAGINATION pAGINATION;

    public void setMESSAGE(String mESSAGE) {
        this.mESSAGE = mESSAGE;
    }

    public String getMESSAGE() {
        return mESSAGE;
    }

    public void setCODE(String cODE) {
        this.cODE = cODE;
    }

    public String getCODE() {
        return cODE;
    }

    public void setDATA(List<ArticleDataItem> dATA) {
        this.dATA = dATA;
    }

    public List<ArticleDataItem> getDATA() {
        return dATA;
    }

    public void setPAGINATION(PAGINATION pAGINATION) {
        this.pAGINATION = pAGINATION;
    }

    public PAGINATION getPAGINATION() {
        return pAGINATION;
    }

    @Override
    public String toString() {
        return
                "AllArticlesResponse{" +
                        "mESSAGE = '" + mESSAGE + '\'' +
                        ",cODE = '" + cODE + '\'' +
                        ",dATA = '" + dATA + '\'' +
                        ",pAGINATION = '" + pAGINATION + '\'' +
                        "}";
    }
}