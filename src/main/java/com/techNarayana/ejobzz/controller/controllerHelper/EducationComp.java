package com.techNarayana.ejobzz.controller.controllerHelper;

import java.util.Comparator;

import com.techNarayana.ejobzz.dto.JobSeekerEducationDetailsDTO;
import com.techNarayana.ejobzz.dto.JobSeekerExperienceDTO;

public class EducationComp implements Comparator<JobSeekerExperienceDTO>{

	@Override
	public int compare(JobSeekerExperienceDTO o1,
			JobSeekerExperienceDTO o2) {
		
		return o1.getEmployeeType().compareToIgnoreCase(o2.getEmployeeType());
	}

}
