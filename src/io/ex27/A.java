package io.ex27;


import java.io.Serializable;


public class A implements Serializable {
    private static final long serialVersionUID = -1429258188600095435L;

    private char character = 'A';
    private B b;

    public A(char c, B b) {
        character = c;
        this.b = b;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "{ c: " + character + ", B: " + b + " }";
    }
}