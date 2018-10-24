package com.jim.points.repository;

import com.jim.points.domain.Points;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Points entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PointsRepository extends JpaRepository<Points, Long> {

    @Query("select points from Points points where points.user_point.login = ?#{principal.username}")
    List<Points> findByUser_pointIsCurrentUser();

}
