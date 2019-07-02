package com.job.web.repositories;

import com.job.web.entities.Jobseeker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository
 */
@Repository
public interface JobseekerRepository extends CrudRepository<Jobseeker, Long>{
    public Jobseeker findBySeekerIdAndPassword(String seekerId, String password);
}