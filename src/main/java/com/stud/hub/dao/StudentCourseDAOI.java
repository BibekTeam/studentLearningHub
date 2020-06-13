package com.stud.hub.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stud.hub.model.CourseDetails;


public interface StudentCourseDAOI extends JpaRepository<CourseDetails, Integer> {

}
