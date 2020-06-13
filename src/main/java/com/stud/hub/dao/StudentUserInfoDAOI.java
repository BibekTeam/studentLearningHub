package com.stud.hub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stud.hub.model.UserInfo;

@Repository
@Transactional
public interface StudentUserInfoDAOI extends JpaRepository<UserInfo, Integer>  {

	UserInfo findByUsername(String userName);

}
