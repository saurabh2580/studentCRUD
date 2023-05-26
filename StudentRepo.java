package com.sms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	public List<Student> findByage(int age);

	public Student findByfirstName(String firstName);

	public Student findByemail(String email);

}
