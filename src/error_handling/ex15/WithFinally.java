package error_handling.ex15;


import error_handling.ex14.OnOffException1;
import error_handling.ex14.OnOffException2;
import error_handling.ex14.OnOffSwitch;
import error_handling.ex14.Switch;


public class WithFinally {
    static Switch sw = new Switch();
    static Integer[] array = new Integer[1];

    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            OnOffSwitch.f(array[0]);
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
    }
} /*
   * Output: on off
   */// :~
