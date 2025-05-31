package com.example.restapi.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // get all student
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    // get all student with name
    public List<Student> getStudentWithName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    // get all student with email
    public Optional<Student> getStudentWithEmail(String email) {
        return studentRepository.findByEmailIgnoreCase(email);
    }

    // add new student
    public boolean addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByEmailIgnoreCase(student.getEmail());
        if (studentOptional.isPresent()) {
            return false;
        }
        studentRepository.save(student);
        return true;
    }

    // edit student info
    @Transactional
    public void updateStudentInfo(Long id,String name,String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student with "+id+"not found"));

        if (!student.getName().equals(name)
        && name != null && !name.isEmpty()) {
            student.setName(name);
        }
        if (!student.getEmail().equals(email)
                && email != null && !email.isEmpty()) {
            Optional<Student> studentOptional = studentRepository.findByEmailIgnoreCase(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email address already exists");
            }
            student.setEmail(email);
        }
    }

    // remove student
    public void removedStudentWithID(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException("Student with id " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }
}
