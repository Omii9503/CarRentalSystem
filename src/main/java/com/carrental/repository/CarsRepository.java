package com.carrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carrental.entities.Cars;

@Repository
public interface CarsRepository extends JpaRepository<Cars,Integer> {
	@Transactional
    @Modifying
    @Query("DELETE FROM Cars c WHERE c.carName = :carName")
    void deleteByCarName(String carName);
	boolean existsByCarName(String carName);
	Cars findByCarName(String carName);
	List<Cars> findBySeatAndCategory(int seats, String segment);
    List<Cars> findBySeat(int seats);
    List<Cars> findByCategory(String segment);
}
