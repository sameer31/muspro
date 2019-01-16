package com.muspro.app.dahira;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface DahiraInfoRepository extends JpaRepository<DahiraInfoEntity, Integer>
{
    List<DahiraInfoEntity> findByNameContainingIgnoreCase(@Param("name") String name);

    List<DahiraInfoEntity> findByLocationContainingIgnoreCase(@Param("location") String location);

    List<DahiraInfoEntity> findByAddressContainingIgnoreCase(@Param("address") String address);

    List<DahiraInfoEntity> findByJawrigneContainingIgnoreCase(@Param("jawrigne") String jawrigne);

    List<DahiraInfoEntity> findByPhoneContainingIgnoreCase(@Param("phone") String phone);

    List<DahiraInfoEntity> findByNameContainingOrLocationContainingOrAddressContainingOrJawrigneContainingOrPhoneContainingAllIgnoreCase(
            @Param("name") String name, @Param("location") String location, @Param("address") String address,
            @Param("jawrigne") String jawrigne, @Param("phone") String phone);
}
