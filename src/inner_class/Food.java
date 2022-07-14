package inner_class;


public class Food {
    /**
     * 익명 클래스
     */
    Object food = new Object(){void method(){}};
    static Object chef = new Object(){void method(){}};

    void cooking() {
        Object cooking = new Object(){void method(){}};
    }
}

