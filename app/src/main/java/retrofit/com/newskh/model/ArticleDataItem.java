package retrofit.com.newskh.model;
import com.google.gson.annotations.SerializedName;

public class ArticleDataItem{

	@SerializedName("STATUS")
	private String sTATUS;

	@SerializedName("IMAGE")
	private String iMAGE;

	@SerializedName("DESCRIPTION")
	private String dESCRIPTION;

	@SerializedName("CREATED_DATE")
	private String cREATEDDATE;

	@SerializedName("CATEGORY")
	private CATEGORY cATEGORY;

	@SerializedName("TITLE")
	private String tITLE;

	@SerializedName("ID")
	private int iD;

	@SerializedName("AUTHOR")
	private AUTHOR aUTHOR;

	public void setSTATUS(String sTATUS){
		this.sTATUS = sTATUS;
	}

	public String getSTATUS(){
		return sTATUS;
	}

	public void setIMAGE(String iMAGE){
		this.iMAGE = iMAGE;
	}

	public String getIMAGE(){
		return iMAGE;
	}

	public void setDESCRIPTION(String dESCRIPTION){
		this.dESCRIPTION = dESCRIPTION;
	}

	public String getDESCRIPTION(){
		return dESCRIPTION;
	}

	public void setCREATEDDATE(String cREATEDDATE){
		this.cREATEDDATE = cREATEDDATE;
	}

	public String getCREATEDDATE(){
		return cREATEDDATE;
	}

	public void setCATEGORY(CATEGORY cATEGORY){
		this.cATEGORY = cATEGORY;
	}

	public CATEGORY getCATEGORY(){
		return cATEGORY;
	}

	public void setTITLE(String tITLE){
		this.tITLE = tITLE;
	}

	public String getTITLE(){
		return tITLE;
	}

	public void setID(int iD){
		this.iD = iD;
	}

	public int getID(){
		return iD;
	}

	public void setAUTHOR(AUTHOR aUTHOR){
		this.aUTHOR = aUTHOR;
	}

	public AUTHOR getAUTHOR(){
		return aUTHOR;
	}

	@Override
 	public String toString(){
		return
			"DATAItem{" +
			"sTATUS = '" + sTATUS + '\'' +
			",iMAGE = '" + iMAGE + '\'' +
			",dESCRIPTION = '" + dESCRIPTION + '\'' +
			",cREATED_DATE = '" + cREATEDDATE + '\'' +
			",cATEGORY = '" + cATEGORY + '\'' +
			",tITLE = '" + tITLE + '\'' +
			",iD = '" + iD + '\'' +
			",aUTHOR = '" + aUTHOR + '\'' +
			"}";
		}
}