package controlling_executions.ex08;


public class SwitchTest {
    public enum Cases {
        FIRST_CASE, SECOND_CASE, THIRD_CASE, FOURTH_CASE
    };

    public static void main(String[] args) {
        Cases[] cases = Cases.values();
        int size = cases.length;
        for(int i = 0; i < size; ++i) {
            // If remove break statements, all downcases will be executed
            switch(cases[i]) {
            case FIRST_CASE:
                System.out.println("1: ");
                break;
            case SECOND_CASE:
                System.out.println("2: ");
                break;
            case THIRD_CASE:
                System.out.println("3: ");
                break;
            case FOURTH_CASE:
                System.out.println("4: ");
                break;
            }
            System.out.println(cases[i].name());
        }
    }
}