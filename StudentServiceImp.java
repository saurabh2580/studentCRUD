package com.sms.service.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sms.model.Student;
import com.sms.repo.StudentRepo;
import com.sms.service.StudentService;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentRepo repo;

	@Autowired
	private SessionFactory factory;

	public void SetStudentServiceImp(StudentRepo repo) {
		this.repo = repo;
	}

	@Override
	public String addStu(Student ss) throws NotFoundException {
		repo.save(ss);
		return "Student added successfully...!";
	}

	@Override
	public String addStuList(List<Student> list) {
		for (Student student : list) {
			repo.save(student);
		}
		return "List of Student added successfully..!";
	}

	@Override
	public Student getStu(Long id) {
		Student ss = this.repo.findById(id).orElse(null);
		return ss;
	}

	@Override
	public Student findByage(int age) {
		List<Student> list = this.repo.findByage(age);
		for (Student student : list) {
			if (student.getAge() == age) {
				return student;
			}
		}
		return null;
	}

	@Override
	public Student findByfirstName(String firstName) {
		Student ss = this.repo.findByfirstName(firstName);
		return ss;
	}

	@Override
	public Student findByemail(String email) {
		Student student = this.repo.findByemail(email);
		return student;
	}

	@Override
	public List<Student> getStuList() {
		List<Student> list = this.repo.findAll();
		return list;
	}

	@Override
	public List<Student> getBetween(Long id, Long id1) {
		Session session = this.factory.openSession();
		HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		JpaCriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

		JpaRoot<Student> root = criteriaQuery.from(Student.class);
		criteriaQuery.select(root).where(criteriaBuilder.between(root.get("id"), id, id1));
		List<Student> students = session.createQuery(criteriaQuery).getResultList();
		session.close();

		return students;
	}

	@Override
	public String updateStu(Long id, Student stuUpdate) throws NotFoundException {
		Student existingStu = this.repo.findById(id).orElseThrow(() -> new NotFoundException());
		existingStu.setFirstName(stuUpdate.getFirstName());
		existingStu.setLastName(stuUpdate.getLastName());
		existingStu.setAge(stuUpdate.getAge());
		existingStu.setPhone(stuUpdate.getPhone());
		existingStu.setEmail(stuUpdate.getEmail());
		repo.save(existingStu);
		return "Student upadted successfully..!";
	}

	@Override
	public String updateName(Long id, Student name) throws NotFoundException {
		Student existingStu = this.repo.findById(id).orElseThrow(() -> new NotFoundException());
		existingStu.setFirstName(name.getFirstName());
		existingStu.setLastName(name.getLastName());
		repo.save(existingStu);
		return null;
	}

	@Override
	public String updatePhone(Long id, Student phone) throws NotFoundException {
		Student existingStu = this.repo.findById(id).orElseThrow(() -> new NotFoundException());
		existingStu.setPhone(phone.getPhone());
		repo.save(existingStu);
		return "Student phone number upadted successfully..!";
	}

	@Override
	public String updateAge(Long id, Student age) throws NotFoundException {
		Student existingStu = this.repo.findById(id).orElseThrow(() -> new NotFoundException());
		existingStu.setAge(age.getAge());
		repo.save(existingStu);
		return "Student age upadted successfully..!";

	}

	@Override
	public String updateEmail(Long id, Student email) throws NotFoundException {
		Student existingStu = this.repo.findById(id).orElseThrow(() -> new NotFoundException());
		existingStu.setEmail(email.getEmail());
		repo.save(existingStu);
		return "Student email address upadted successfully..!";

	}

	@Override
	public String updateRollNum(Long id, Student rollNum) throws NotFoundException {
		Student existingStu = this.repo.findById(id).orElseThrow(() -> new NotFoundException());
		existingStu.setRollNumber(rollNum.getRollNumber());
		repo.save(existingStu);
		return "Student rollnumber upadted successfully..!";

	}

	@Override
	public String deleteStu(Long id) {
		this.repo.deleteById(id);
		return "Student deleted successfully..!";
	}

}
