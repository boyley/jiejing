package com.jiejing.locker.util;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * Created by lenovo on 2016/9/9.
 */
public class SpecificationUtil {

    /**
     * @param predicates
     * @return
     */
    public static Predicate[] toPredicateArray(List<Predicate> predicates) {
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
