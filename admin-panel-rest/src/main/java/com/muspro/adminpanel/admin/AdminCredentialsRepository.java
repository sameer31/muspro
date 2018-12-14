package com.muspro.adminpanel.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AdminCredentialsRepository extends JpaRepository<AdminCredentialsEntity, Integer>
{
    List<AdminCredentialsEntity> fetchByUserName(@Param("userName") String userName);
}
