package com.job.web.repositories;

import java.util.Optional;

import com.job.web.entities.Jobseeker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository
 */
@Repository
public interface JobseekerRepository extends CrudRepository<Jobseeker, Long>{
    public Jobseeker findBySeekerIdAndPassword(String seekerId, String password);
    public Optional<Jobseeker> findBySeekerId(String seekerId);
}