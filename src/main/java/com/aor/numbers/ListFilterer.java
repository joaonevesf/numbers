package com.aor.numbers;


import java.util.ArrayList;
import java.util.List;

public class ListFilterer {

    GenericListFilter filter;
    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }
    public List<Integer> filter(List<Integer> list) {
        List<Integer> result = new ArrayList<Integer>();
        for(Integer x : list) {
             if (filter.accept(x)) {
                 result.add(x);
            }
        }
        return result;
    }
}
