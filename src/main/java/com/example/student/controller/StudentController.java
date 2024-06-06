package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.Student;
import com.example.student.service.StudentService;

//@Controller
//public class StudentController {
////     @GetMapping("/hello")
////	@ResponseBody
////	public String main() {
////		return "Hello";
////	}
//	
	
import java.util.List;

;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	// SaveOneRecord
	@PostMapping("/students")
	public ResponseEntity<Student> save(@RequestBody Student student) {
		return new ResponseEntity<Student>(service.save(student), HttpStatus.CREATED);
	}

	// SaveMultipleRecords
	@PostMapping("/students/many")
	public ResponseEntity<List<Student>> saveMultiple(@RequestBody List<Student> list) {
		return new ResponseEntity<List<Student>>(service.saveMultiple(list), HttpStatus.CREATED);
	}

	// FetchAllRecords
	@GetMapping("/students")
	public ResponseEntity<List<Student>> fetchAll() {
		return new ResponseEntity<List<Student>>(service.fetchAll(), HttpStatus.FOUND);
	}

	// FetchRecordById
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> fetchRecord(@PathVariable int id) {
		return new ResponseEntity<Student>(service.fetchById(id), HttpStatus.FOUND);
	}

	// FetchRecordsByMobile
	@GetMapping("/students/mobile/{mobile}")
	public ResponseEntity<List<Student>> fetchByMobile(@PathVariable long mobile) {
		return new ResponseEntity<List<Student>>(service.fetchByMobile(mobile), HttpStatus.FOUND);
	}

	// FetchRecordsByName
	@GetMapping("/students/name/{name}")
	public ResponseEntity<List<Student>> fetchByName(@PathVariable String name) {
		return new ResponseEntity<List<Student>>(service.fetchByName(name), HttpStatus.FOUND);
	}

	// FetchRecordsByResult
	@GetMapping("/students/result/{result}")
	public ResponseEntity<List<Student>> fetchByResult(@PathVariable String result) {
		return new ResponseEntity<List<Student>>(service.fetchByResult(result), HttpStatus.FOUND);
	}

	// FetchbyMarksGreater
	@GetMapping("/students/greater/{subject}/{marks}")
	public ResponseEntity<List<Student>> fetchByMarksGreaterInSubject(@PathVariable String subject,
			@PathVariable int marks) {
		return new ResponseEntity<List<Student>>(service.fetchByMarksGreaterInSubject(subject, marks),
				HttpStatus.FOUND);
	}

	// FetchbyMarksLess
	@GetMapping("/students/less/{subject}/{marks}")
	public ResponseEntity<List<Student>> fetchByMarksLessInSubject(@PathVariable String subject,
			@PathVariable int marks) {
		return new ResponseEntity<List<Student>>(service.fetchByMarksLessInSubject(subject, marks), HttpStatus.FOUND);
	}

	// FetchRecordById
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> deleteRecord(@PathVariable int id) {
		return new ResponseEntity<Student>(service.deleteRecord(id), HttpStatus.OK);
	}

	// UpdateRecordPut
	@PutMapping("/students")
	public ResponseEntity<Student> updateRecord(@RequestBody Student student) {
		return new ResponseEntity<Student>(service.updateRecord(student), HttpStatus.OK);
	}

	// UpdateRecordPatch
	@PatchMapping("/students/{id}")
	public ResponseEntity<Student> updateRecord(@RequestBody Student student, @PathVariable int id) {
		return new ResponseEntity<Student>(service.updateRecord(student, id), HttpStatus.OK);
	}

}
	
	
     

