package com.realestate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.realestate.entity.Property;

public interface PropertyDao extends JpaRepository<Property, Integer> {

}
