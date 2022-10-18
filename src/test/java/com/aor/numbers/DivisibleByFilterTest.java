package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    @Test
    public void filter() {
        GenericListFilter filter1 = new DivisibleByFilter(2);
        GenericListFilter filter3 = new DivisibleByFilter(3);
        int a = 44;
        int b = 30;
        int c = 15;

        Assertions.assertEquals(true, filter1.accept(a));
        Assertions.assertEquals(false, filter3.accept(a));
        Assertions.assertEquals(true, filter1.accept(b));
        Assertions.assertEquals(true, filter3.accept(b));
        Assertions.assertEquals(false, filter1.accept(c));
        Assertions.assertEquals(true, filter3.accept(c));
    }
}
