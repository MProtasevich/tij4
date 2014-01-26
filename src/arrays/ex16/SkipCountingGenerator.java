package arrays.ex16;


import net.mindview.util.Generator;


public class SkipCountingGenerator {
    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value;
        private boolean n;

        Boolean(int n) {
            this.n = (n % 2 == 0);
        }

        @Override
        public java.lang.Boolean next() {
            value = n ? value : !value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        private byte value;
        private int n;

        Byte(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Byte next() {
            value += n;
            return value;
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Character implements Generator<java.lang.Character> {
        private int index = -1;
        private int n;

        Character(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Character next() {
            index = (index + n) % chars.length;
            return chars[index];
        }
    }

    public static class String implements Generator<java.lang.String> {
        private int length = 7;
        private Generator<java.lang.Character> cg;

        public String(int length, int n) {
            this.length = length;
            this.cg = new SkipCountingGenerator.Character(n);
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[length];

            for(int i = 0; i < length; ++i) {
                buf[i] = cg.next();
            }

            return new java.lang.String(buf);
        }
    }

    public static class Short implements Generator<java.lang.Short> {
        private short value = 0;
        private int n;

        Short(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Short next() {
            value += n;
            return value;
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private int value = 0;
        private int n;

        Integer(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Integer next() {
            value += n;
            return value;
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        private long value = 0;
        private int n;

        Long(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Long next() {
            value += n;
            return value;
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        private float value = 0;
        private int n;

        Float(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Float next() {
            float result = value;
            value += n;
            return result;
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        private double value = 0.0;
        private int n;

        Double(int n) {
            this.n = n;
        }

        @Override
        public java.lang.Double next() {
            double result = value;
            value += n;
            return result;
        }
    }
}
