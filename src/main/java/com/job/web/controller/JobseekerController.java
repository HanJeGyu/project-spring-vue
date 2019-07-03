package com.job.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import com.job.web.domain.JobseekerDTO;
import com.job.web.entities.Jobseeker;
import com.job.web.repositories.JobseekerRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class JobseekerController {

    @Autowired JobseekerRepository jbrep;
    @Autowired JobseekerDTO jobseekerDTO;
    @Autowired ModelMapper modelMapper;

    @GetMapping("/count")
    public long count(){
		return jbrep.count();
    }

    @GetMapping("/{id}")
	public JobseekerDTO findBySeekerId(@PathVariable String id){
        return modelMapper.map(jbrep.findBySeekerId(id).get(), JobseekerDTO.class);
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
            if(modelMapper.map(jbrep.save(modelMapper.map(dto, Jobseeker.class)), JobseekerDTO.class).getSeekerId().equals("")){
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
            if(modelMapper.map(jbrep.save(modelMapper.map(dto, Jobseeker.class)), JobseekerDTO.class).getSeekerId().equals("")){
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

    @DeleteMapping("/{id}")
	public HashMap<String, String> del(@PathVariable String id){
        HashMap<String, String> map = new HashMap<>();
        jbrep.deleteById(Long.parseLong(id));
        map.put("result", "SUCCESS");
        return map;
    }
}