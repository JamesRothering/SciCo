class GenSeqImpl2Digit
{

  final char[] sSequence;

 //constructor
 public GenSeqImpl2Digit(String aSequence)
 {
   sSequence = aSequence.toCharArray();
 }

 public String getNextDigit(String aDigit) 
 {
   //this string is only one character long
   char aChar = aDigit.charAt(0);
   for (int i =0; i<this.sSequence.length; i++)
   {
     if (aChar == sSequence[i])
     {
       if (i == sSequence.length-1)
         return new Character(sSequence[0]).toString();
       else
         return new Character(sSequence[i+1]).toString();
     }
   }
   return ("-1"); // should never hit this, only if there is no match
 }

 public static void main(String[] argv)
 {
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
   System.out.println("Got back======>  " + aTest.getNextDigit(aStart));
   System.out.println("--------------------------------------------------");
 }
}
