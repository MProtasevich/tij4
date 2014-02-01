package io.ex27;


import java.io.Serializable;


public class B implements Serializable {
    private static final long serialVersionUID = -768156527088817823L;
    private char character = 'B';

    public B(char c) {
        character = c;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}