public class GenSeqImpl2 implements GenSeq
{
  static GenSeqImpl2Digit lsd;

  public GenSeqImpl2(String aString)
  {
    lsd  = new GenSeqImpl2Digit(aString);
  }

  public static void main(String[] argv)
  {
    GenSeqImpl2.testCase("01", "");
    GenSeqImpl2.testCase("01", "1");
    GenSeqImpl2.testCase("01", "00");
    GenSeqImpl2.testCase("01", "01");
    GenSeqImpl2.testCase("01", "10");
    GenSeqImpl2.testCase("01", "11");
    GenSeqImpl2.testCase("01", "000");
    GenSeqImpl2.testCase("01", "110");
    GenSeqImpl2.testCase("01", "111");
    GenSeqImpl2.testCase("01", "1000");
    GenSeqImpl2.testCase("01", "1001");
    GenSeqImpl2.testCase("01", "1010");
    GenSeqImpl2.testCase("01", "1011");
//
//A different sequence tested
    GenSeqImpl2.testCase("abcdefg","");
    GenSeqImpl2.testCase("abcdefg","a");
    GenSeqImpl2.testCase("abcdefg","b");
    GenSeqImpl2.testCase("abcdefg","g");
    GenSeqImpl2.testCase("abcdefg","gg");
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
    this.lsd.setToNextDigit();     
  }

  public String getCurrentValue()
  {
    return this.lsd.getCurrentValue();
  }

  static public void testCase(String aSeq,   //The sequence to use
                              String aInput) //The value to increment from
  {
    GenSeqImpl2 aTest = new GenSeqImpl2(aSeq);

    System.out.println("Using sequence:  " + aSeq);
    System.out.println("Starting value:  " + aInput);
    aTest.setToNextInSeq();
    System.out.println("got back =====>  " + aTest.getCurrentValue() ); 
    System.out.println("-------------------------------------------------");
  }
}
