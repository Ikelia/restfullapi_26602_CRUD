package com.restapi.controller.student;

import com.restapi.model.student.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    private List<Student> students = new ArrayList<>();
    private Long nextId = 6L;

    public StudentController() {
        // Initialize with 5 sample students
        students.add(new Student(1L, "John", "Doe", "john.doe@email.com", "Computer Science", 3.8));
        students.add(new Student(2L, "Jane", "Smith", "jane.smith@email.com", "Computer Science", 3.9));
        students.add(new Student(3L, "Mike", "Johnson", "mike.j@email.com", "Business", 3.2));
        students.add(new Student(4L, "Sarah", "Williams", "sarah.w@email.com", "Engineering", 3.6));
        students.add(new Student(5L, "Tom", "Brown", "tom.b@email.com", "Computer Science", 3.4));
    }

    // GET /api/students - Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }

    // GET /api/students/{studentId} - Get student by ID
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        return students.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .map(student -> ResponseEntity.ok(student))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // GET /api/students/major/{major} - Get all students by major
    @GetMapping("/major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable String major) {
        List<Student> result = students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    // GET /api/students/filter?gpa={minGpa} - Filter students with GPA >= minimum
    @GetMapping("/filter")
    public ResponseEntity<List<Student>> filterStudentsByGpa(@RequestParam Double gpa) {
        List<Student> result = students.stream()
                .filter(student -> student.getGpa() >= gpa)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    // POST /api/students - Register a new student
    @PostMapping
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        student.setStudentId(nextId++);
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    // PUT /api/students/{studentId} - Update student information
    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                updatedStudent.setStudentId(studentId);
                students.set(i, updatedStudent);
                return ResponseEntity.ok(updatedStudent);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // DELETE /api/students/{studentId} - Delete a student
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        boolean removed = students.removeIf(student -> student.getStudentId().equals(studentId));
        if (removed) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
