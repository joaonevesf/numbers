package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {
    @Test
    public void filter() {
        GenericListFilter filter = new PositiveFilter();
        int a = -5;
        int b = 0;
        int c = 5;

        Assertions.assertEquals(false, filter.accept(a));
        Assertions.assertEquals(false, filter.accept(b));
        Assertions.assertEquals(true, filter.accept(c));
    }
}
