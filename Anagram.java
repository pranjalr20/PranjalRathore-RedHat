import java.util.Arrays;
import java.util.Scanner;

class Anagram {
  public static void main(String[] args) {

   
    Scanner input = new Scanner(System.in);

    
    System.out.print("Enter first String: ");
    String str1 = input.nextLine();
    System.out.print("Enter second String: ");
    String str2 = input.nextLine();

   
    if(str1.length() == str2.length()) {

      
      char[] charArray1 = str1.toCharArray();
      char[] charArray2 = str2.toCharArray();

      
      Arrays.sort(charArray1);
      Arrays.sort(charArray2);

      
      boolean result = Arrays.equals(charArray1, charArray2);

      if(result) {
        System.out.println("True");
      }
      else {
        System.out.println("False");
      }
    }
    else {
        System.out.println("False");
      }
    

    input.close();
  }
}
