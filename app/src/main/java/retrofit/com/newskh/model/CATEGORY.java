package retrofit.com.newskh.model;

import com.google.gson.annotations.SerializedName;

public class CATEGORY {

    @SerializedName("ID")
    private int iD;

    @SerializedName("NAME")
    private Object nAME;

    public void setID(int iD) {
        this.iD = iD;
    }

    public int getID() {
        return iD;
    }

    public void setNAME(Object nAME) {
        this.nAME = nAME;
    }

    public Object getNAME() {
        return nAME;
    }

    @Override
    public String toString() {
        return
                "CATEGORY{" +
                        "iD = '" + iD + '\'' +
                        ",nAME = '" + nAME + '\'' +
                        "}";
    }
}