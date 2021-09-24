//Break a Palindrome
public class Day23 {
    public String breakPalindrome(String palindrome) {

        if (palindrome.length() < 2)
            return "";

        String replace = "";

        //for forward propagating, check if char is not 'a'. If not 'a', then put starting from 'a' to 'z'
        for (int i = 0; i <= palindrome.length() / 2; i++) {
            char[] text = palindrome.toCharArray();

            if (text[i] - 'a' > 0) {
                for (int j = 'a'; j < (char)text[i]; j++) {
                    text[i] = (char) j;
                    replace = String.valueOf(text);
                    if(!isPalindrome(replace)){
                        return replace;
                    }else continue;

                }
            } else continue;

        }

        //for backwards propagating, means forward propagating failed. Only one possible, that is first & last char is 'a', so just keep adding to 'z'. 
        for (int i = palindrome.length() - 1; i >= palindrome.length()/2; i--) {
            char[] textt = palindrome.toCharArray();

                for (int j = 'b'; j < 'z'; j++) {
                    textt[i] = (char) j;
                    replace = String.valueOf(textt);
                    if(!isPalindrome(replace)){
                        return replace;
                    }else continue;
                }
        }

        return "";
    }


    public boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String rev = sb.toString();
        if (str.equals(rev)) {
            return true;
        } else {
            return false;
        }

    }
}
