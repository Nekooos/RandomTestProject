package random;

public class NameToNumber {
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyzåäö".toCharArray();

    private int getcharPosition(char letter) {
        var position = 1;
        for (int i=0; i<alphabet.length; i++) {
            if(alphabet[i] == letter) {
                position = i+1;
            }
        }
        return position;
    }

    public int sumWord(String word) {
        var sum = 0;
        for (int i=0; i<word.length(); i++) {
            sum = sum + getcharPosition(Character.toLowerCase(word.charAt(i)));
        }
        return sum;
    }
}
