package com.job.web.controller;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;

import com.job.web.domain.JobseekerDTO;
import com.job.web.entities.Jobseeker;
import com.job.web.repositories.JobseekerRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JobseekerController
 */
@RestController
@RequestMapping("/jobseekers")
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class JobseekerController {

    @Autowired JobseekerRepository jobseekerRepository;
    @Autowired JobseekerDTO jobseekerDTO;
    @Autowired ModelMapper modelMapper;

    @GetMapping("/count")
    public long count(){
		return jobseekerRepository.count();
    }
    
    @PostMapping("/login")
    public JobseekerDTO login(@RequestBody JobseekerDTO dto) throws IllegalArgumentException{
        try{
            Function<JobseekerDTO, Jobseeker> fx = (o) ->{
                return jobseekerRepository.findBySeekerIdAndPassword(dto.getSeekerId(), dto.getPassword());
            };
            return modelMapper.map(fx.apply(dto), JobseekerDTO.class);
        }catch(IllegalArgumentException e){
            System.out.println(e);
            return jobseekerDTO;
        }
    }

    @PostMapping("/join")
    public HashMap<String, String> join(@RequestBody JobseekerDTO dto){
        HashMap<String, String> map = new HashMap<>();
/*         Jobseeker entity = Jobseeker.builder()
									.seekerId(dto.getSeekerId())
									.seekerName(dto.getSeekerName())
									.password(dto.getPassword())
									.birth6(dto.getBirth6())
									.phone(dto.getPhone())
									.email(dto.getEmail())
									.industry(dto.getIndustry())
									.location(dto.getLocation())
									.build(); */
        Jobseeker entity = new Jobseeker();
        entity.setSeekerId(dto.getSeekerId());
        entity.setSeekerName(dto.getSeekerName());
        entity.setPassword(dto.getPassword());
        entity.setBirth6(dto.getBirth6());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setIndustry(dto.getIndustry());
        entity.setLocation(dto.getLocation());
        jobseekerDTO = modelMapper.map(jobseekerRepository.save(entity), JobseekerDTO.class);
        if(jobseekerDTO.getSeekerId().equals("")){
            map.put("result", "FAIL");
        }else{
            map.put("result", "SUCCESS");
        }
        return map;
    }
}