package com.mua.hbs.repository;

import com.mua.hbs.model.LoginCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginCredentialRepository extends JpaRepository<LoginCredential,Long> {
}
