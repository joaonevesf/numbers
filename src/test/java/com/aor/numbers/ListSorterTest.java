package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ListSorterTest {

    List<Integer> list;

    @Test
    public void sort() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void bug_sorter_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(Arrays.asList(1,2,2,4),sorted);
    }

    @BeforeEach
    public void helper() {
        list = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
    }

}
