package enums.ex05;


import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;


public enum VowelsAndConsonants {
    VOWEL('a', 'e', 'i', 'o', 'u'),
    SOMETIMES_A_VOWEL('w', 'y'),
    CONSONANT('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q',
              'r', 's', 't', 'v', 'x', 'z');
    private Character[] letters;

    private VowelsAndConsonants(Character... letters) {
        this.letters = letters;
    }

    public static VowelsAndConsonants LetterType(Character c)
            throws NoSuchElementException {
        if(Arrays.asList(VOWEL.letters).contains(c)) {
            return VOWEL;
        } else if(Arrays.asList(SOMETIMES_A_VOWEL.letters).contains(c)) {
            return SOMETIMES_A_VOWEL;
        } else if(Arrays.asList(CONSONANT.letters).contains(c)) {
            return CONSONANT;
        }
        throw new NoSuchElementException();
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for(int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';
            printnb((char)c + ", " + c + ": ");
            print(LetterType((char)c));
        }
    }
}