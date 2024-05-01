package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.Cliente;

import jakarta.transaction.Transactional;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Transactional
	Cliente findByEmail(String email);
}