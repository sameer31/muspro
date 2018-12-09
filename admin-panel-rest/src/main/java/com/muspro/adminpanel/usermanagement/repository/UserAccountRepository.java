package com.muspro.adminpanel.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muspro.adminpanel.usermanagement.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>
{

}
