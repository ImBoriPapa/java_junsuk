package lambda;

public class Calculator {
    public static void main(String[] args) {

        /**
         * 익명 클래스
         */
        Function plus1 = new Function() {
            @Override
            public int plus(int a, int b) {
                return a+b;
            }
        };


        /**
         * 람다식
         */
        Function plus2 = (a, b) -> a + b;

        int plus1Result = plus1.plus(1, 2);
        int plus2Result = plus1.plus(2, 4);

        /**
         *   operate(Operate f) 메서드에 매개변수를 Operate 타입이면 메서드를 호출할때 람다식을 참조하는 참조변수를 매개변수로 지정
         */
        Operate run = ()-> System.out.println("Operate Start");

        operate(run);

        System.out.println("plus1Result = " + plus1Result);
        System.out.println("plus2Result = " + plus2Result);

        /**
         * 참조 변수 없이 직접 람다식을 매개변수로 지정
         */
        operate(()->System.out.println("Operate finish"));

        /**
         * casting1 : 형변환
         * casting2 : Object 타입으로 형변환
         */
        Operate casting1 = (Operate)()-> System.out.println("casting 1");

        Object casting2 =(Object)(Operate)()-> System.out.println("casting 2");

        String casting3 =((Object)(Operate)()-> System.out.println("casting 3")).toString();

        System.out.println("casting1 = " + casting1);
        System.out.println("casting2 = " + casting2);
        System.out.println("casting3 = " + casting3);
    }

    /**
     * 매겨변수의 타입이 함수형 인터페이스
     */
    static void operate(Operate f){
         f.run();
    }
}
