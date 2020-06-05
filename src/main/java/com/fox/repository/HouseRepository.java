package com.fox.repository;

import com.fox.entity.Component;
import com.fox.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House,Long> {
}
