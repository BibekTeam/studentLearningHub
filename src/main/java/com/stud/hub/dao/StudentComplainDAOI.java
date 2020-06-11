package com.stud.hub.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stud.hub.model.Complain;


@Repository
@Transactional
public interface StudentComplainDAOI extends JpaRepository<Complain, Integer>{

}