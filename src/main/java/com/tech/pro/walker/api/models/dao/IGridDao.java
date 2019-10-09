package com.tech.pro.walker.api.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.pro.walker.api.models.entity.Grid;

public interface IGridDao extends JpaRepository<Grid, Long> {

}
