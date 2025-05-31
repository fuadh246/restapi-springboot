package com.example.restapi.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")

public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getStudent();
    }

    @GetMapping(path = "{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return studentService.getStudentWithName(name);
    }
    @GetMapping(path = "/email/{email}")
    public Optional<Student> getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentWithEmail(email);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        boolean result = studentService.addNewStudent(student);
        if (result) {
            System.out.println("Student added successfully");
        }
        else {
            throw new IllegalStateException("Email address already exists");
        }
    }

    @PutMapping(path = "{id}")
    public void updateStudent(
            @PathVariable("id") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        studentService.updateStudentInfo(studentId,name,email);
    }

    @DeleteMapping(path="{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.removedStudentWithID(id);
    }
}
