package inner_class;

/**
 * Pizza : 외부 클래스
 * MakePizza : 내부 클래스
 */
public class PizzaHouse {

     int price = 10000;

    /**
     * 인스턴스 클래스(instance class)
     * 외부 클래스의 멤버에 접근이 가능하다.
     */
     class Pizza {
       int price = 15000;

       void OrderPizza() {
            int price = 5000;
            System.out.println("price = " + price);
            System.out.println("this.price = " + this.price);
            System.out.println("PizzaHouse.this.price = " + PizzaHouse.this.price);
        }
    }


    /**
     * 스태틱 클래스(static class)
     */
    static class Pasta {
        int price = 20000;
    }


    /**
     * 지역 클래스(local class)
     */

    static void OrderPasta() {
        class OrderPasta {}
    }
    

}

class PastaHouse {
    public static void main(String[] args) {
    PizzaHouse pizzaHouse = new PizzaHouse();
        PizzaHouse.Pizza pizza = pizzaHouse.new Pizza();
        pizza.OrderPizza();

    }
}