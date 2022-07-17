package lambda;

public class OuterCastle {
    String name = "Outer Castle"; //OuterCastle.this.name

    class InnerCastle {
        String name = "Inner Castle";//this.name

        void palace(String king) {
            String name = "Palace"; //name
//            king = "new King"; //final String king 상수 이므로 값을 변경할 수 없다.
            MyCastle castle = () -> {
                System.out.println("king      : "+king);
                System.out.println("name      : "+ name);
                System.out.println("this.name : "+this.name);
                System.out.println("OuterCastle.this.name : "+OuterCastle.this.name);
            };
            castle.method();

        }
    }
}

@FunctionalInterface
interface MyCastle {
    void method();
}

class castle{
    public static void main(String[] args) {
        OuterCastle outerCastle = new OuterCastle();
        OuterCastle.InnerCastle innerCastle = new OuterCastle().new InnerCastle();
        innerCastle.palace("king");
    }
}