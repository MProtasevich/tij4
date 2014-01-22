package generics.ex08;

public class StoryCharacter {
    private static int count = 0;
    private final int id = count++;

    @Override
    public String toString() {
        return this.getClass().getName() + ", id: " + id;
    }
}