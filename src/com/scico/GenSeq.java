public class GenSeq
{
  final String aSequence;
  final char[] sSeq;
  final char   aMaxValue;
  final char   aMinValue;

  public GenSeq(String aString)
  {
    aSequence  = aString;
    sSeq       = aString.toCharArray();
    aMaxValue  = sSeq[sSeq.length-1];
    aMinValue  = sSeq[0];
  }

  public static void main(String[] argv)
  {
    GenSeq.testCase("01", "110");
    GenSeq.testCase("01", "111");
  }

  public String getNextInSeq(String aInput)
  {
    char[] sWorking = aInput.toCharArray();
    char[] sReturn  = new char[sWorking.length+1]; //need extra char to bump up as MSD
    for (int i = sWorking.length-1; i >= 0; i--)
    {
      if (sWorking[i] == aMaxValue)
      {
        while (i >= 0 &&   //can't loop forever & we short circuit before using an invalid array value in the next test
               sWorking[i] == aMaxValue 
              )
        {
          sReturn[i] = aMinValue;  //reset this one to the minimum value
                                   // because the higher MSD will get incr.
          i--; //remember to decrement, because of REVERSE order
        }
      }//end-if-then-clause
      else
      {
//System.out.println("at the i=" + i);
        sReturn[i] = getNextDigit(sWorking[i],
                                  this.sSeq); //put the next in sequence into return value
        while (i>0)
        {
//System.out.println("sReturn.length=" + sReturn.length);
          i--;                     //copy over the remaining leading digits
          sReturn[i] = sWorking[i];
        }
      }                         // but remember we're going in REVERSE order, so we decrement.
    }//end-for

//TODO: FIX
    return (new String(sReturn));
  }

  public char getNextDigit(char aChar, char[] sChar) 
  {
    for (int i = 0, j=sChar.length; i < sChar.length; i++,j--)
    {
      if (aChar == sChar[i])
      {
//        System.out.println("returning next in sequence of: " + sChar[j-1]);
        return sChar[j-1];
      }
    }
    return (char) -1;  //should never hit this, only if there is no match
  }

  static public void testCase(String aSeq,   //The sequence to use
                              String aInput) //The value to increment from
  {
    GenSeq aTest = new GenSeq(aSeq);

    System.out.println("Using sequence:  " + aSeq);
    System.out.println("Starting value:  " + aInput);
    System.out.println("got back =====>  " + aTest.getNextInSeq(aInput) ); 
    System.out.println("-------------------------------------------------");
  }
}
