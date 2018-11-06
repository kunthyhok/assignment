package retrofit.com.newskh.model;

import com.google.gson.annotations.SerializedName;

public class PAGINATION{

	@SerializedName("TOTAL_COUNT")
	private int tOTALCOUNT;

	@SerializedName("TOTAL_PAGES")
	private int tOTALPAGES;

	@SerializedName("PAGE")
	private int pAGE;

	@SerializedName("LIMIT")
	private int lIMIT;

	public void setTOTALCOUNT(int tOTALCOUNT){
		this.tOTALCOUNT = tOTALCOUNT;
	}

	public int getTOTALCOUNT(){
		return tOTALCOUNT;
	}

	public void setTOTALPAGES(int tOTALPAGES){
		this.tOTALPAGES = tOTALPAGES;
	}

	public int getTOTALPAGES(){
		return tOTALPAGES;
	}

	public void setPAGE(int pAGE){
		this.pAGE = pAGE;
	}

	public int getPAGE(){
		return pAGE;
	}

	public void setLIMIT(int lIMIT){
		this.lIMIT = lIMIT;
	}

	public int getLIMIT(){
		return lIMIT;
	}

	@Override
 	public String toString(){
		return 
			"PAGINATION{" + 
			"tOTAL_COUNT = '" + tOTALCOUNT + '\'' + 
			",tOTAL_PAGES = '" + tOTALPAGES + '\'' + 
			",pAGE = '" + pAGE + '\'' + 
			",lIMIT = '" + lIMIT + '\'' + 
			"}";
		}
}