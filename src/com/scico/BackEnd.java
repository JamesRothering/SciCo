package com.scico;

public class BackEnd {

  private enum Singleton
  {
    private int aNextNum = 0;
    
    public void getNextNum()
    {
      return aNextNum;
    }
    
  }
  
	public static void main(String[] args) 
	{
	}
  
	BackEnd(int aNum)
	{
	  //instantiate with an assumedly correct "next" number for SSCCEs
	  Singleton.aNextNum = aNum;
	}
}
