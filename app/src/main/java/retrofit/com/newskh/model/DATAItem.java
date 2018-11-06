package retrofit.com.newskh.model;

import com.google.gson.annotations.SerializedName;

public class DATAItem{

	@SerializedName("ID")
	private int iD;

	@SerializedName("NAME")
	private String nAME;

	public void setID(int iD){
		this.iD = iD;
	}

	public int getID(){
		return iD;
	}

	public void setNAME(String nAME){
		this.nAME = nAME;
	}

	public String getNAME(){
		return nAME;
	}

	@Override
 	public String toString(){
		return 
			"DATAItem{" + 
			"iD = '" + iD + '\'' + 
			",nAME = '" + nAME + '\'' + 
			"}";
		}
}