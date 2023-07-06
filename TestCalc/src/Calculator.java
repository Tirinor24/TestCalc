import java.util.Arrays;
import java.util.Scanner;
public class Calculator {
    public static void main (String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(Main.calc(input));
    }
}

class Main {
    private static String output;
    private static int a;
    private static int b;
    private static int result;
    private static boolean isRoman;
    private static String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XXXX",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
      public static String calc(String input) throws Exception {
        String[] elements = input.split(" ");
        if (elements.length != 3) {
            throw new Exception();
        }

        if ((Arrays.asList(romanNumerals).contains(elements[0])) && (Arrays.asList(romanNumerals).contains(elements[2]))) {
            isRoman = true;
            a = Arrays.asList(romanNumerals).indexOf(elements[0]) + 1;
            b = Arrays.asList(romanNumerals).indexOf(elements[2]) + 1;
          } else {
                try {
                    a = Integer.parseInt(elements[0]);
                    b = Integer.parseInt(elements[2]);
                } catch (NumberFormatException e) {
                    throw new Exception();
                }
          }

        if (a>10 || b>10 || a<1 || b<1) {
            throw new Exception();
        }

        switch (elements[1]) {
              case  ("+"):
                  result = a+b;
                  break;
              case ("-"):
                  result = a-b;
                  break;
              case ("*"):
                  result = a*b;
                  break;
              case ("/"):
                  result = a/b;
                  break;
            default:
                throw new Exception();
          }

        if (isRoman) {
            if (result<1) {
                throw new Exception();
            } else {
                output = romanNumerals[result-1];
            }
        } else output = Integer.toString(result);

        return output;
    }
}
