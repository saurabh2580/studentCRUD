package com.sms.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sms.model.Student;

public interface StudentService {

	public String addStu(Student ss) throws NotFoundException;

	public String addStuList(List<Student> list);

	public Student findByage(int age);

	public Student findByfirstName(String firstName);

	public Student findByemail(String email);

	public Student getStu(Long id);

	public List<Student> getStuList();
	
	public List<Student> getBetween(Long id, Long id1);

	public String updateStu(Long id, Student stuUpdate) throws NotFoundException;

	public String updateName(Long id, Student name) throws NotFoundException;

	public String updatePhone(Long id, Student phone) throws NotFoundException;
	
	public String updateAge(Long id, Student age) throws NotFoundException;

	public String updateEmail(Long id, Student email) throws NotFoundException;

	public String updateRollNum(Long id, Student rollNum) throws NotFoundException;
	
	public String deleteStu(Long id) throws NotFoundException;
	
	

	
}
