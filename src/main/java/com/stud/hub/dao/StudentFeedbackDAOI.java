package com.stud.hub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stud.hub.model.Feedback;

@Repository
@Transactional
public interface StudentFeedbackDAOI extends JpaRepository<Feedback, Integer> {

}
