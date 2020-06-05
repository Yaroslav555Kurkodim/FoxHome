package com.fox.repository;

import com.fox.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends JpaRepository<Component,Long> {
}
