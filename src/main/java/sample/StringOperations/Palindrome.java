package sample.StringOperations;

public class Palindrome {

    public static String checkIsTheWordAPolindrom(String word)  {

        if (word.equals(null)|| word.equals("")){
            throw new NullPointerException("inputString cannot be null");
        }
            char[] arr = word.toCharArray();
            int length = arr.length - 1;

            for (int k = 0; k <= Math.floor(length/2); k++) {
                if (arr[k] != arr[length-k]) {
                return "Is Not A Palindrome";
                }
        }
        return "Is A Palindrome";
    }

}



