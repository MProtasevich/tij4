package inner_classes.ex25;


import inner_classes.ex24.GreenhouseControls;
import inner_classes.ex24.controller.Event;


public class GreenhouseControlsEx extends GreenhouseControls {
    public static class WaterMistGenerator extends Event {
        private boolean active = false;

        public WaterMistGenerator(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            active = !active;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}