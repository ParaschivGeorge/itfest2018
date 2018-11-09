package com.twoguysonepanda.itfest2018.repository;

import com.twoguysonepanda.itfest2018.entities.TestObject;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Api(tags = "TestObject Entity")
@RepositoryRestResource(collectionResourceRel = "testObject", path = "test-object")
public interface TestObjectRepository extends CrudRepository<TestObject, Long>, JpaSpecificationExecutor<TestObject> {
    List<TestObject> findByName(@Param("name") String name);

    @Query(value = "select TO from TestObject TO join TO.miniTestObjects MTO " +
            "where upper(MTO.name) like concat('%', coalesce(upper(:MTOname), ''), '%')")
    List<TestObject> findByMiniTestObjectName(@Param("MTOname") String MTOname);
}
