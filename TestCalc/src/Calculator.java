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
    private static String[] romanNumerals = {"i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix", "x",
            "xi", "xii", "xiii", "xiv", "xv", "xvi", "xvii", "xviii", "xix", "xx",
            "xxi", "xxii", "xxiii", "xxiv", "xxv", "xxvi", "xxvii", "xxviii", "xxix", "xxx",
            "xxxi", "xxxii", "xxxiii", "xxxiv", "xxxv", "xxxvi", "xxxvii", "xxxviii", "xxxix", "xxxx",
            "xli", "xlii", "xliii", "xliv", "xlv", "xlvi", "xlvii", "xlviii", "xlix", "l",
            "li", "lii", "liii", "liv", "lv", "lvi", "lvii", "lviii", "lix", "lx",
            "lxi", "lxii", "lxiii", "lxiv", "lxv", "lxvi", "lxvii", "lxviii", "lxix", "lxx",
            "lxxi", "lxxii", "lxxiii", "lxxiv", "lxxv", "lxxvi", "lxxvii", "lxxviii", "lxxix", "lxxx",
            "lxxxi", "lxxxii", "lxxxiii", "lxxxiv", "lxxxv", "lxxxvi", "lxxxvii", "lxxxviii", "lxxxix", "xc",
            "xci", "xcii", "xciii", "xciv", "xcv", "xcvi", "xcvii", "xcviii", "xcix", "c"};
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

        if (a>10 || b>10) {
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