package com.aor.numbers

import spock.lang.Specification

class ListAggregatorSpockTest extends Specification {
    private def list

    def setup() {
        list = Arrays.asList(1,2,4,2,5)
    }

    def 'testing sum'() {
        given:
        def aggregator = new ListAggregator()
        when:
        def sum = aggregator.sum(list)
        then:
        14 == sum
    }
    def 'testing max'() {
        given:
        def aggregator = new ListAggregator()
        when:
        def sum = aggregator.max(list)
        then:
        5 == max
    }
    def 'testing disctint bug 8726'() {
        given:
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
        result == Arrays.asList(1,2,4)
    }
}