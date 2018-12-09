package com.muspro.adminpanel.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muspro.adminpanel.usermanagement.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>
{

}
