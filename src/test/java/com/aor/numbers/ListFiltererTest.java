package com.aor.numbers;

import com.sun.tools.javac.jvm.Gen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    @Test
    public void sort() {
        List<Integer> expected1 = Arrays.asList( 2, 4, 8, 0, 200);
        List<Integer> expected2 = Arrays.asList( 3, 4, 9, 50, 400);
        List<Integer> list1 = Arrays.asList( 2, 3, 4, 5, 8, 0, 200, 201);
        List<Integer> list2 = Arrays.asList(-500, -3, 3, 0, 4, -20, 9, 50, 400);
        ListFilterer filter1 = new ListFilterer(new DivisibleByFilter(2));
        ListFilterer filter2 = new ListFilterer(new PositiveFilter());
        Assertions.assertEquals(expected1, filter1.filter(list1));
        Assertions.assertEquals(expected2, filter2.filter(list2));
    }
}
