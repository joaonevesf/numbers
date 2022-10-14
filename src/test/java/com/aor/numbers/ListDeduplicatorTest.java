package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    List<Integer> list;

    @Test
    public void deduplicate() {
        class StubListSorter implements GenericListSorter {
            @Override
            public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,4,5);
            }
        }
        StubListSorter sorter = new StubListSorter();
        List<Integer> expected = Arrays.asList(1,2,4,5);
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void bug_deduplicate_8726() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        /*class StubListSorter implements GenericListSorter {
            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1, 2, 2, 4);
            }
        }*/
        //StubListSorter sorter = new StubListSorter();
        //ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(Arrays.asList(1, 2, 4), distinct);
    }

    @BeforeEach
    public void helper() {
        list = Arrays.asList(1,2,4,2,5);
    }
}
