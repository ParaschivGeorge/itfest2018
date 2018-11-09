package com.twoguysonepanda.itfest2018.repository;

import com.twoguysonepanda.itfest2018.entities.MiniTestObject;
import com.twoguysonepanda.itfest2018.entities.TestObject;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class TestObjectSpecifications {

    public static Specification<TestObject> hasNameLikeAndhasMiniObejctNameLike(String TOname, String MTOname) {
        return new Specification<TestObject>() {
            @Override
            public Predicate toPredicate(Root<TestObject> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Join<MiniTestObject, TestObject> miniTestObjects = root.join("testObject");

                final List<Predicate> predicateList = new ArrayList<>();

                if (TOname != null && !TOname.isEmpty()) {
                    predicateList.add(cb.like(cb.upper(root.get("name")), TOname.toUpperCase()));
                }

                if (MTOname != null && !TOname.isEmpty()) {
                    predicateList.add(cb.like(cb.upper(miniTestObjects.get("name")), MTOname.toUpperCase()));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }
}
