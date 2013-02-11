package com.scico;

public class BackEnd {

  private static enum Singleton
  {;
  
    private static int aNextNum = 0;
    
    static public int getNextNum()
    {
      return aNextNum;
    }
    static public void setNextNum(int aNum)
    {
      aNextNum = aNum;
    }
  } 
 
  
	public static void main(String[] args) 
	{
	}
  
	BackEnd(int aNum)
	{
	  //instantiate with an assumedly correct "next" number for SSCCEs
	  BackEnd.Singleton.setNextNum(aNum);
	}
	
	public int getNextFileId()
	{
	  return BackEnd.Singleton.getNextNum();
	}
}
