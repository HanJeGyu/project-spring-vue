package com.job.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * JobseekerDTO
 */
@Data
@Lazy
@Component
public class JobseekerDTO {

    private Long id;
    private String seekerId, seekerName, password, birth6, phone, email, industry, location;
}