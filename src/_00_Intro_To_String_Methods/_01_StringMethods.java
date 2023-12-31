package _00_Intro_To_String_Methods;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	int s1L=s1.length();
    	int s2L=s2.length();
	 	String longer=s1;
    	if(s2L>s1L) {
    		longer=s2;
    	}
   
        return longer;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	if(s.contains("underscores")){
    		s=s.replaceAll(" ", "_");
    	}
        return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	
        return null;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	//***need to for loop through the string***
    	int sum=0;
    	for (int i = 0; i < s.length(); i++) {
    		if (Character.isDigit(s.charAt(i))) {
				
			
   int num=Integer.parseInt(""+s.charAt(i));
		sum=sum+num;
		}
    	}
        return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	int times=0;
    	 List<Integer> bruh=new ArrayList<>();
    	for (int i = 0; i < s.length(); i++) {
    		Pattern pattern = Pattern.compile(substring);
            Matcher match = pattern.matcher(s);
            while(match.find(i)){
                times++;
                bruh.add(match.start());
                i = match.start() + 1;
		}
    }
    	return times;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	
    	
return Utilities.encrypt(s.getBytes(), (byte) key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {

        return Utilities.decrypt(s, (byte)key);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	int times=0;
    	      String[] subStrings = s.split(" ");
    	      for(String subString: subStrings) {
    	    	  if (subString.endsWith(substring)) {
        	    	  times++;
				}

    	      }
    	      return times;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	
        return 0;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String

    public static void main(String[] args)
    {
    	palindrome("att");
    }    
    
    public static boolean palindrome(String s) {
    	char[]first=s.toCharArray();
    	char[]last=s.toCharArray();
    	for (int i = 0; i < s.length()/2; i++) {
    		if (first[i]!=last[s.length()-1-i]) {
				return false;
			}
		}
    	return true;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
