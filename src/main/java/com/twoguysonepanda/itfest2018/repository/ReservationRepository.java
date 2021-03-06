package com.twoguysonepanda.itfest2018.repository;

import com.twoguysonepanda.itfest2018.entities.Reservation;
import com.twoguysonepanda.itfest2018.entities.User;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Api(tags = "Reservation Entity")
@RepositoryRestResource(collectionResourceRel = "reservation", path = "reservation")
public interface ReservationRepository extends CrudRepository<Reservation, Long>, JpaSpecificationExecutor<Reservation> {
    List<Reservation> findByUser(User user);
    List<Reservation> findByUserEmail(@Param("email")String email);
    List<Reservation> findAllByDate(@Param("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date);
}
