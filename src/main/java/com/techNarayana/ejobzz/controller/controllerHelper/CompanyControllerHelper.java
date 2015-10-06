package com.techNarayana.ejobzz.controller.controllerHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.techNarayana.ejobzz.domain.EmployerDomain;
import com.techNarayana.ejobzz.dto.CompanyDto;
import com.techNarayana.ejobzz.service.CompanyService;
import com.techNarayana.ejobzz.util.FilePath;

@Component
public class CompanyControllerHelper {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	FilePath filePath;

	public String renameFile(String name) {
		Integer maxId = companyService.getMaxKeyId();
		String nameExtArr[] = name.split("\\.");
		if (maxId == null)
			maxId = 0;
		maxId++;

		return maxId.toString().concat("." + nameExtArr[1]);
	}

	public EmployerDomain createCompany(CompanyDto companyDto) {

		System.out.println("inside create company ");

		EmployerDomain  companyDomain = new EmployerDomain();
		InputStream inputStream = null;
		OutputStream outputStream = null;
		MultipartFile file = companyDto.getFile();
		String name = file.getOriginalFilename();
		String fileName = null;
		if (name == null || name.equals("")) {

		} else {
			fileName = renameFile(name);
			try {

				inputStream = file.getInputStream();
				System.out.println("file path : "+filePath.getCompanyFilePath());
				File newFile = new File(filePath.getCompanyFilePath());
				if (!newFile.exists())
					newFile.mkdir();
				newFile = new File(newFile, fileName);
				if (!newFile.exists()) {
					newFile.createNewFile();
				}
				outputStream = new FileOutputStream(newFile);
				int read = 0;
				byte[] bytes = new byte[1024];

				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);

				}
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String excludeProperties[]={"file","imgPath"};
		BeanUtils.copyProperties(companyDto, companyDomain,excludeProperties);
		companyDomain.setImgPath(fileName);
		companyDomain.setStatus('A');
		companyDomain.setCreatetsDate(new Timestamp(new java.util.Date().getTime()));
		companyDomain = companyService.createCompany(companyDomain);
		return companyDomain;
	}

	public EmployerDomain ChangePassword(String newPwd, Integer companyKey) {
		return companyService.ChangePassword(newPwd,companyKey);
		
	}

}
