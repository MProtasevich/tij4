//: enumerated/menu/Course.java
package enums.ex03;


import net.mindview.util.Enums;


public enum Course {
    APPETIZER(Food.Appetizer.class), MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class), COFFEE(Food.Coffee.class),
    MYCOURSE(Food.MyCourse.class);

    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}