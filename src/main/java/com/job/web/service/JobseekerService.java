package com.job.web.service;

import java.util.Optional;

import com.job.web.entities.Jobseeker;
import com.job.web.repositories.JobseekerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * JobseekerService
 */
@Service
public class JobseekerService {

    @Autowired JobseekerRepository jobseekerRepository;

    public long count(){
        return jobseekerRepository.count();
    }
    
    public void delete(Jobseeker entity){
        jobseekerRepository.delete(entity);
    }
    
    public void deleteAll(){
        jobseekerRepository.deleteAll();
    }
    
    public void deleteAll(Iterable<Jobseeker> entities){
        jobseekerRepository.deleteAll(entities);	
    }
    
    public void deleteById(Long id){
        jobseekerRepository.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return jobseekerRepository.existsById(id);
    }
    
    public Iterable<Jobseeker> findAll(){
        return jobseekerRepository.findAll();
    }
    
    public Iterable<Jobseeker> findAllById(Iterable<Long> ids){
        return jobseekerRepository.findAllById(ids);
    }
    
    public Optional<Jobseeker> findById(Long id){
        return jobseekerRepository.findById(id);
    }
    
    public Jobseeker save(Jobseeker entity){
        return jobseekerRepository.save(entity);
    }
    
    public Iterable<Jobseeker> saveAll(Iterable<Jobseeker> entities){
        return jobseekerRepository.saveAll(entities);
    }
}