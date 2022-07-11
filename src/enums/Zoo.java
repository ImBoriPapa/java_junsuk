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
         */
        Animals[] animals = Animals.values();
        for (Animals animalKind : animals) {
            System.out.println("animalKind = " + animalKind);
        }

        /**
         * ordinal()
         */
        Animals[] ordinal = Animals.values();
        for (Animals animalKind : ordinal) {
            System.out.println("animalKind = " + animalKind+", animalKind.ordinal() = " + animalKind.ordinal());
        }

    }
}
