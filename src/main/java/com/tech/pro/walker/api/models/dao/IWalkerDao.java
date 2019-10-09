package com.tech.pro.walker.api.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.pro.walker.api.models.entity.Walker;

public interface IWalkerDao extends JpaRepository<Walker, Long> {

}
