//BackEnd
package com.scico;

import java.io.*;

public class BackEnd
{

    private static enum Singleton
    {INSTANCE;
  
      private int aNextNum = 0;
    
      public int getNextNum()
      {
        return aNextNum;
      }
      public void setNextNum(int aNum)
      {
        aNextNum = aNum;
      //
      }
    }

    public void createDir(String aBase, String aName)
    {
      Boolean didWork = new File(aBase+aName).mkdirs();
      System.out.println(didWork);
    }
 
  
	public static void main(String[] args) 
	{
	  BackEnd aTest = new BackEnd(6);
	  System.out.println("ran BackEnd from the command line");
          aTest.createDir("c:\\djr\\SciCo\\","k34");
	}
  
	BackEnd(int aNum)
	{
	  //instantiate with an assumed correct "next" number for SSCCEs
	  BackEnd.Singleton.INSTANCE.setNextNum(aNum);
	}
	
	public int getNextFileId()
	{
	  return BackEnd.Singleton.INSTANCE.getNextNum();
	}
}
