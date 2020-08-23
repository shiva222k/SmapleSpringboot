package com.hackerrank.sample.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.sample.model.Model;

@Repository("modelRepository")
public interface ModelRepository extends JpaRepository<Model, Long> {
	@Transactional
	Long deleteById(Long id);
}
