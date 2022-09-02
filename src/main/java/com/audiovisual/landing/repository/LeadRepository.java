package com.audiovisual.landing.repository;

import com.audiovisual.landing.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Integer> {
}