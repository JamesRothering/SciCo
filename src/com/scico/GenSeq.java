//daily backup
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
    GenSeq aTest = new GenSeq("01");
    System.out.println("sSeq was instantiated with the sequence " + aTest.aSequence);
    System.out.println("got back ==> " + aTest.getNextInSeq("110") );
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
        sReturn[i] = sSeq[i-1]; //put the next in sequence into return value
      }                         // but remember we're going in REVERSE order, so we decrement.
    }//end-for

//TODO: FIX
    return (new String(sWorking));
  }

}
