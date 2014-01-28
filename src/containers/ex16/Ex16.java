package containers.ex16;


import containers.Maps;


public class Ex16 {
    public static void main(String[] args) {
        SlowMap<Integer, String> slowMap = new SlowMap<Integer, String>();
        Maps.test(slowMap);
    }
}