package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    List<Integer> elements;
    int count;

    @BeforeAll
    static void prepare() {
        System.out.println("Tests start!");
    }

    @BeforeEach
     void initArrayList() {
        this.elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
    }

    @Test
    void testTake() {
        // BEGIN
        count = 4;
        Assertions.assertEquals(Implementations.right(elements, count), Arrays.asList(1, 2, 3));

        elements.clear();
        Assertions.assertEquals(Implementations.wrong1(elements, count), List.of(0));


        elements.add(1);
        Assertions.assertEquals(Implementations.wrong2(elements, count), List.of(1, 100));

        count = 2;
        elements.add(2);
        Assertions.assertEquals(Implementations.wrong3(elements, count), List.of(1, 2, 10));

        // END
    }
}
