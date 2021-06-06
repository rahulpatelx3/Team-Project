package com.realestate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestate.entity.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

}
