package enums;



public class Zoo {
    public static void main(String[] args) {

        Animals animal;
        Animals russianBlue = Animals.CAT;
        Animals  regDoll = Animals.CAT;
        Animals siberian_husky = Animals.DOG;

        /**
         *  == 비교
         *  equals 비교
         *  compareTo()비교
         *  switch 문의 조건식에 사용
         */
        if (russianBlue == Animals.CAT) {
            System.out.println("russianBlue is a Cat");
        } else {
            System.out.println("russianBlue is not a Cat");
        }

        if (regDoll.equals(Animals.DOG)) {
            System.out.println("regDoll is a Dog");
        } else {
            System.out.println("regDoll is not a Dog");
        }

        System.out.println(siberian_husky.compareTo(Animals.DOG)); //결과 0
        System.out.println(siberian_husky.compareTo(Animals.CAT)); //결과 1
        System.out.println(siberian_husky.compareTo(Animals.BIRD)); //결과 -1

        animal = Animals.CAT;

        switch (animal) {
            case CAT:
                System.out.println("is a cat");
                break;

            case DOG:
                System.out.println("is a DOG");
                break;

            case BIRD:
                System.out.println("is a BIRD");
                break;
        }
        /**
         * values()
         * 열거형의 모든 상수를 배열에 담아 반환
         */
        Animals[] animals = Animals.values();
        for (Animals animalKind : animals) {
            System.out.println("animalKind = " + animalKind);
        }

        /**
         * ordinal()
         * 열거형 상수가 정의된를 0 부터 시작해서 정수로 반환
         */
        Animals[] ordinal = Animals.values();
        for (Animals animalKind : ordinal) {
            System.out.println("animalKind = " + animalKind+", animalKind.ordinal() = " + animalKind.ordinal());
        }


        /**
         * getDeclaringClass()
         * 열거형 class 객체를 반환
         */
        Class<Animals> declaringClass = Animals.CAT.getDeclaringClass();
        System.out.println("declaringClass = " + declaringClass);

        /**
         * name()
         * 열거형 상수의 이름을 문자열로 반환
         */
        String name = Animals.CAT.name();
        System.out.println("name = " + name);

        /**
         * valueOf(Class<T> enumType, String name)
         * 지정된 열거형에서 name 과 일치하는 열거형 상수를 반환
         */
        Animals animals1 = Animals.valueOf("CAT");
        Animals animals2 = Enum.valueOf(Animals.class, "DOG");
        System.out.println("animals1 = " + animals1);
        System.out.println("animals2 = " + animals2);

        /**
         * 열거형의 정의된 상수들을 배열로 반환한다.
         */
        Animals[] values = Animals.values();
        for (Animals value : values) {
            System.out.println("value = " + value);
        }

        ZodiacSigns mouse = ZodiacSigns.MOUSE;
        System.out.println("mouse = " + mouse);
        System.out.println("mouse.getNumberOrder() = " + mouse.getNumberOrder());
        System.out.println("mouse.getKorean() = " + mouse.getKorean());

        ZodiacSigns[] zodiacSigns = ZodiacSigns.values();
        for (ZodiacSigns zodiacSign : zodiacSigns) {
            System.out.println("zodiacSign.name(), = " + zodiacSign.name()+", Order = "+zodiacSign.getNumberOrder()
            +", Korean = "+zodiacSign.getKorean());
        }

        String mouseTti = mouse.tti();
        System.out.println("mouseTti = " + mouseTti);

    }
}
