package com.job.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import com.job.web.domain.JobseekerDTO;
import com.job.web.entities.Jobseeker;
import com.job.web.repositories.JobseekerRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JobseekerController
 */
@RestController
@RequestMapping("/jobseekers")
public class JobseekerController {

    @Autowired JobseekerRepository jbrep;
    @Autowired JobseekerDTO jobseekerDTO;
    @Autowired ModelMapper modelMapper;

    @GetMapping("/count")
    public long count(){
		return jbrep.count();
    }

    @GetMapping("/{seekerId}")
	public JobseekerDTO findBySeekerId(@PathVariable String seekerId){
        return modelMapper.map(jbrep.findBySeekerId(seekerId).get(), JobseekerDTO.class);
    }
    
    @GetMapping("/list")
	public List<JobseekerDTO> findAll(){
		List<JobseekerDTO> list = new ArrayList<>();
		for(Jobseeker s : jbrep.findAll()){
			jobseekerDTO = modelMapper.map(s, JobseekerDTO.class);
			list.add(jobseekerDTO);
		}
		return list;
	}
    
    @PostMapping("/login")
    public JobseekerDTO login(@RequestBody JobseekerDTO dto) throws IllegalArgumentException{
        try{
            Function<JobseekerDTO, Jobseeker> fx = (o) ->{
                return jbrep.findBySeekerIdAndPassword(dto.getSeekerId(), dto.getPassword());
            };
            return modelMapper.map(fx.apply(dto), JobseekerDTO.class);
        }catch(IllegalArgumentException e){
            System.out.println(e);
            return null;
        }
    }

    @PutMapping("/modify")
    public HashMap<String, String> modify(@RequestBody JobseekerDTO dto){
        HashMap<String, String> map = new HashMap<>();
        try {
            Jobseeker entity = Jobseeker.builder()
                    .seekerId(dto.getSeekerId())
                    .seekerName(dto.getSeekerName())
                    .password(dto.getPassword())
                    .birth6(dto.getBirth6())
                    .phone(dto.getPhone())
                    .email(dto.getEmail())
                    .industry(dto.getIndustry())
                    .location(dto.getLocation())
                    .build();
            entity.setId(jbrep.findBySeekerId(dto.getSeekerId()).get().getId());
            if(modelMapper.map(jbrep.save(entity) ,JobseekerDTO.class).getSeekerId().equals("")){
                map.put("result", "FAIL");
            }else{
                map.put("result", "SUCCESS");
            }
            return map;
        }catch(Exception e){
            System.out.println("회원수정 error : " + e);
            map.put("result", "FAIL");
            return map;
        }
    }

    @PostMapping("/join")
    public HashMap<String, String> join(@RequestBody JobseekerDTO dto){
        HashMap<String, String> map = new HashMap<>();
        try {
            if(modelMapper.map(jbrep.save(Jobseeker.builder()
                                                    .seekerId(dto.getSeekerId())
                                                    .seekerName(dto.getSeekerName())
                                                    .password(dto.getPassword())
                                                    .birth6(dto.getBirth6())
                                                    .phone(dto.getPhone())
                                                    .email(dto.getEmail())
                                                    .industry(dto.getIndustry())
                                                    .location(dto.getLocation())
                                                    .build())
                                                    ,JobseekerDTO.class).getSeekerId().equals("")){
                map.put("result", "FAIL");
            }else{
                map.put("result", "SUCCESS");
            }
            return map;
        }catch(Exception e){
            System.out.println("회원가입 error : " + e);
            map.put("result", "FAIL");
            return map;
        }
    }

    @DeleteMapping("/{seekerId}")
	public HashMap<String, String> del(@PathVariable String seekerId){
        HashMap<String, String> map = new HashMap<>();
        try {
            jbrep.deleteById(jbrep.findBySeekerId(seekerId).get().getId());
            map.put("result", "SUCCESS");
            return map;
        }catch(Exception e){
            map.put("result", "FAIL");
            return map;
        }
        
    }
}