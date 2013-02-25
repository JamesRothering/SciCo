//Second implementation of the gen sequence algorithm
package com.scico;
public class GenSeqImpl2 implements GenSeq
{
  static GenSeqImpl2Digit lsd;

  public GenSeqImpl2(String aString)
  {
    lsd  = new GenSeqImpl2Digit(aString);
  }

  public static void main(String[] argv)
  {
    GenSeqImpl2 aTest = new GenSeqImpl2("01");
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
//
//A different sequence tested
    aTest = new GenSeqImpl2("abcdefg");
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
    GenSeqImpl2.testCase(aTest);
  }

//TODO: fix up the interface, which I've now really changed.
// this is just to adhere to the interface, which I've really moved away from
  public String getNextInSeq(String aInput)
  {
    setToNextInSeq();
    return getCurrentValue();
  }

  public void setToNextInSeq()
  {
    GenSeqImpl2.lsd.setToNextDigit();     
  }

  public String getCurrentValue()
  {
    return GenSeqImpl2.lsd.getFullCurrentValue();
  }

  static public void testCase(GenSeqImpl2 aTest) //The value to increment from
  { 
    aTest.setToNextInSeq();
    System.out.println("got back =====>  " + aTest.getCurrentValue() ); 
    System.out.println("-------------------------------------------------");
  }
}
