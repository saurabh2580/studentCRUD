package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Student;
import com.sms.service.StudentService;

@RestController
public class StuController {

	@Autowired
	private StudentService service;

	public void SetStuController(StudentService service) {
		this.service = service;
	}

	@PostMapping("/addone") // done
	public ResponseEntity<String> addStu(@RequestBody Student ss) throws NotFoundException {
		try {
			this.service.addStu(ss);
			return ResponseEntity.ok("Student Added successfully...!");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not adedd..!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	@PostMapping("/addlistof") // done
	public String addStuList(@RequestBody List<Student> list) {
		String msg = service.addStuList(list);
		return msg;
	}

	@GetMapping("/findage/{age}") // done
	public Student findByage(@PathVariable int age) {
		return this.service.findByage(age);
	}

	@GetMapping("/findid/{id}") // done
	public Student getStu(@PathVariable long id) {
		return this.service.getStu(id);
	}

	@GetMapping("/findname/{firstName}") // done
	public Student findByfirstName(@PathVariable String firstName) {
		return this.service.findByfirstName(firstName);
	}

	@GetMapping("/findemail/{email}")
	public Student findByemail(@PathVariable String email) throws NotFoundException {
		return this.service.findByemail(email);
	}

	@GetMapping("/getall") // done
	public List<Student> getStuList() {
		return this.service.getStuList();
	}

	@GetMapping("/getbetween/{id}/{id1}") // done
	public List<Student> getBetween(@PathVariable Long id, @PathVariable Long id1) {
		return this.service.getBetween(id, id1);
	}

	@PutMapping("/updateallfiled/{id}") // done
	public ResponseEntity<String> updateStu(@PathVariable Long id, @RequestBody Student stuUpadte) {
		try {
			service.updateStu(id, stuUpadte);
			return ResponseEntity.ok("Studednt updated successfully");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This " + id + "Student not found");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	@PutMapping("/updatefirstandlastname/{id}") // done
	public ResponseEntity<String> updateName(@PathVariable Long id, @RequestBody Student name)
			throws NotFoundException {
		try {
			this.service.updateName(id, name);
			return ResponseEntity.ok("Studednt name updated successfully");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This " + id + "Student not found");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	@PutMapping("/updatephone/{id}") // done
	public ResponseEntity<String> updatePhone(@PathVariable Long id, @RequestBody Student name)
			throws NotFoundException {
		try {
			this.service.updatePhone(id, name);
			return ResponseEntity.ok("Studednt Phone updated successfully");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This " + id + "Student not found");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	@PutMapping("/updateage/{id}") // done
	public ResponseEntity<String> updateAge(@PathVariable Long id, @RequestBody Student age) throws NotFoundException {
		try {
			this.service.updateAge(id, age);
			return ResponseEntity.ok("Studednt age updated successfully");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This " + id + "Student not found");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	@PutMapping("/updateemail/{id}") // done
	public ResponseEntity<String> updateEmail(@PathVariable Long id, @RequestBody Student email)
			throws NotFoundException {
		try {
			this.service.updateEmail(id, email);
			return ResponseEntity.ok("Studednt email address updated successfully");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This " + id + "Student not found");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	@PutMapping("/updaterollnumber/{id}") // done
	public ResponseEntity<String> updateRollNumber(@PathVariable Long id, @RequestBody Student rollNum)
			throws NotFoundException {
		try {
			this.service.updateRollNum(id, rollNum);
			return ResponseEntity.ok("Studednt rollnumber updated successfully");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This " + id + "Student not found");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletStu(@PathVariable Long id) throws NotFoundException {
		try {
			this.service.deleteStu(id);
			return ResponseEntity.ok("Student deleted successfully...!");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This " + id + " Student not found");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}
}
