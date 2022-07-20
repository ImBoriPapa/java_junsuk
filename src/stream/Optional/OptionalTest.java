package stream.Optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

public class OptionalTest {

    public static void main(String[] args) {
        Long memberId = 101L;
        String userId = null;
        String name;
        int age;

        /**
         * Optional<T>
         *     of()
         *     ofNullable()
         */
        Optional<Long> optionalLong = Optional.of(memberId);
        System.out.println("optionalLong = " + optionalLong);



        Optional<String> stringOfNullable = Optional.ofNullable(userId);
        System.out.println("stringOfNullable = " + stringOfNullable);


        Optional<String> nullValue = Optional.ofNullable(null);

//        System.out.println("stringOf.get = " + nullValue.get());// NullPointerException

        System.out.println("stringOf.orElse = " + nullValue.orElse("널입니다."));

        String elseGet = nullValue.orElseGet(String::new);
        System.out.println("elseGet = " + elseGet);

//        String elseThrow = nullValue.orElseThrow(NullPointerException::new);
//        System.out.println("elseThrow = " + elseThrow);

        /**
         * isPresent
         * ifPresent
         */
        if (Optional.ofNullable(null).isPresent()) {
            System.out.println("isPresent null = false");
        }
        System.out.println("isPresent not null = true");

        Optional.ofNullable("널이 아닙니다").ifPresent(System.out::println);



    }
}
