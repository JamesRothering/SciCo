//author: DJR
public class GenSeqImpl1 implements GenSeq
{
  final String aSequence;
  final char[] sSeq;
  final char   aMaxValue;
  final char   aMinValue;

  public GenSeqImpl1(String aString)
  {
    aSequence  = aString;
    sSeq       = aString.toCharArray();
    aMaxValue  = sSeq[sSeq.length-1];
    aMinValue  = sSeq[0];
  }

  public static void main(String[] argv)
  {
    GenSeqImpl1.testCase("01", "");
    GenSeqImpl1.testCase("01", "1");
    GenSeqImpl1.testCase("01", "00");
    GenSeqImpl1.testCase("01", "01");
    GenSeqImpl1.testCase("01", "10");
    GenSeqImpl1.testCase("01", "11");
    GenSeqImpl1.testCase("01", "000");
    GenSeqImpl1.testCase("01", "110");
    GenSeqImpl1.testCase("01", "111");
    GenSeqImpl1.testCase("01", "1000");
    GenSeqImpl1.testCase("01", "1001");
    GenSeqImpl1.testCase("01", "1010");
    GenSeqImpl1.testCase("01", "1011");
//
//A different sequence tested
    GenSeqImpl1.testCase("abcdefg","");
    GenSeqImpl1.testCase("abcdefg","a");
    GenSeqImpl1.testCase("abcdefg","b");
    GenSeqImpl1.testCase("abcdefg","g");
    GenSeqImpl1.testCase("abcdefg","gg");
  }

  public String getNextInSeq(String aInput)
  {
    char[] sWorking = aInput.toCharArray();
    char[] sReturn  = new char[sWorking.length];
    if(aInput.equals(""))
      return (Character.toString(aMinValue));
    boolean isToBeBumpedUp = true; //this digit needs incrementing
    for (int i = sWorking.length-1; i >= 0; i--)
    {
      if (isToBeBumpedUp)
      {
        //if at max value, reset to min value but leave flag to bump up next digit
        //else set to next value & set isToBeBumpedUp false
        if(sWorking[i] == aMaxValue)
        {
          sReturn[i] = aMinValue; 
        }
        else //set to the next value & set isToBeBumpedUp false
        {
          sReturn[i] = getNextDigit(sWorking[i],sSeq);
          isToBeBumpedUp = false;
        }
      }
      else //if not ToBeBumpedUp
      {
        //just copy it
        sReturn[i] = sWorking[i];
      }
    }//end-for
    //if at the end of the for loop we still have isToBeBumpedUp==true
    //then we need to slap on another MSD and set it to next value up from Min value
    if (isToBeBumpedUp)
    {
       char[] sRetVal = new char[sReturn.length+1];
       sRetVal[0] = aMinValue; //concat the char at the front
       //note: aMinValue is still correct, even if it's a leading zero
       //i.e., the sequence built off of "01" and given"11" should be followed by 000!
       //don't be misled by binary math!!! These are sequences of symbols
       for (int i = 0; i < sReturn.length; i++)  //copy the rest
       {
         sRetVal[i+1] = sReturn[i];
       }
       //convert to String
      return (new String(sRetVal));
     }
    return (new String(sReturn));   
  }

  public char getNextDigit(char aChar, char[] sChar) 
  {
    for (int i = 0, j=sChar.length; i < sChar.length; i++,j--)
    {
      if (aChar == sChar[i])
      {
        return sChar[i+1];  
      }
    }
    return (char) -1;  //should never hit this, only if there is no match
  }

  static public void testCase(String aSeq,   //The sequence to use
                              String aInput) //The value to increment from
  {
    GenSeqImpl1 aTest = new GenSeqImpl1(aSeq);

    System.out.println("Using sequence:  " + aSeq);
    System.out.println("Starting value:  " + aInput);
    System.out.println("got back =====>  " + aTest.getNextInSeq(aInput) ); 
    System.out.println("-------------------------------------------------");
  }
}
