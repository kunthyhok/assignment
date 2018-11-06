package retrofit.com.newskh.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class CategoryResponse{

	@SerializedName("MESSAGE")
	private String mESSAGE;

	@SerializedName("CODE")
	private String cODE;

	@SerializedName("DATA")
	private List<DATAItem> dATA;

	@SerializedName("PAGINATION")
	private Object pAGINATION;

	public void setMESSAGE(String mESSAGE){
		this.mESSAGE = mESSAGE;
	}

	public String getMESSAGE(){
		return mESSAGE;
	}

	public void setCODE(String cODE){
		this.cODE = cODE;
	}

	public String getCODE(){
		return cODE;
	}

	public void setDATA(List<DATAItem> dATA){
		this.dATA = dATA;
	}

	public List<DATAItem> getDATA(){
		return dATA;
	}

	public void setPAGINATION(Object pAGINATION){
		this.pAGINATION = pAGINATION;
	}

	public Object getPAGINATION(){
		return pAGINATION;
	}

	@Override
 	public String toString(){
		return 
			"CategoryResponse{" + 
			"mESSAGE = '" + mESSAGE + '\'' + 
			",cODE = '" + cODE + '\'' + 
			",dATA = '" + dATA + '\'' + 
			",pAGINATION = '" + pAGINATION + '\'' + 
			"}";
		}
}