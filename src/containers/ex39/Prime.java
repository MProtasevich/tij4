package containers.ex39;


public class Prime {
    public static int firstPrimeAfter(int n) {
        for(int i = n + 1; i > n; ++i) {
            int factors = 0;
            for(int j = 1; j < (i + 2) / 2; ++j) {
                if((i % j) == 0)
                    factors++;
            }
            if(factors < 2) {
                return i;
            }
        }
        return 0;
    }
}