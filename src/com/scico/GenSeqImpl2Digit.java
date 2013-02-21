//note to reader: sequences are different from numbers in that numbers
// have implicit leading zeros which are not meaningful to make explicit
// i.e., 13 and 013 are the same number. But 99 and 099 are different sequences.
// So when you flip over from the highest value in the sequence, you
// just add in an MSD with the lowest value possible. If your sequence is "01"
// this will not match binary counting, because you will go 0, 1, 00, 01, 10, 11,
// 000. But in numbers, 0, 00, and 000 are all the same -- 0!
class GenSeqImpl2Digit
{
  GenSeqImpl2Digit MSD = null;  //start out without a more significant digit
  final  char[] sSequence;
  char currentValue;      

 //constructor
 public GenSeqImpl2Digit(String aSequence)
 {
   sSequence    = aSequence.toCharArray();
   currentValue = sSequence[0];
 }

 public String getCurrentValue()
 {
   if (this.MSD == null)
   {
     return Character.toString(this.currentValue);
   }
   else
   {
      return (this.MSD.getCurrentValue() + Character.toString(this.currentValue) ); 
   }
 }

 public void incrementMSD()
 {
   if (null == this.MSD)
   {
     this.MSD = new GenSeqImpl2Digit(new String(sSequence));
   }
   else
   {
     this.MSD.setToNextDigit(new String(sSequence));
   }
 }
 public void setToNextDigit()
 {
   setToNextDigit(Character.toString(currentValue));
 }

 public void setToNextDigit(String aDigit)
 {
   assert (aDigit.length() == 1); //this is just a digit
   if (aDigit == "")
   {//if were priming the sequence, the empty string should set to lowest value
     this.currentValue = sSequence[0];
   }
   else
   {
     char aChar = aDigit.charAt(0);
     for (int i =0; i<this.sSequence.length; i++)
     {
       if (aChar == sSequence[i])
       {
         if (i == sSequence.length-1)
         {//when the max sequence is reached, start over at beginning
           this.currentValue = sSequence[0];
           //and then bump up the more significant digit
           incrementMSD();
         }
         else
         {//otherwise set this digit to the next value in the sequence
           this.currentValue = sSequence[i+1];
         }
       }
     }
   }
 
 }

 public static void main(String[] argv)
 {
   testCase("01","");
   testCase("01","0");
   testCase("01","1");
   testCase("abcdefg","a");
   testCase("abcdefg","b");
   testCase("abcdefg","c");
   testCase("abcdefg","d");
   testCase("abcdefg","e");
   testCase("abcdefg","f");
   testCase("abcdefg","g");
 }

 public static void testCase(String aSequence, String aStart)
 {
   GenSeqImpl2Digit aTest = new GenSeqImpl2Digit(aSequence);
   System.out.println("Using sequence:  " + aSequence);
   System.out.println("Starting value:  " + aStart);
   aTest.setToNextDigit(aStart);
   System.out.println("Got back======>  " + aTest.getCurrentValue());
   System.out.println("--------------------------------------------------");
 }
}
