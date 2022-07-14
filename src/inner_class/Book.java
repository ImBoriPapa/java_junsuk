package inner_class;

/**
 * 익명 클래스
 */
public class Book {
    public static void main(String[] args) {

        Pageable pageable = new Pageable() {
            @Override
            public void nextPage() {
                System.out.println("Next Page!");
            }

            @Override
            public void previousPage() {
                System.out.println("Go previous!");
            }
        };

        pageable.nextPage();
        pageable.previousPage();
    }


}

interface Pageable{
    void nextPage();
    void previousPage();
}
