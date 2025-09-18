package com.example.studentapp.service;

import com.example.studentapp.model.Student;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Create a single student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Create multiple students
    public List<Student> createStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    // Update student
    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setCompany(updatedStudent.getCompany());
                    student.setSkills(updatedStudent.getSkills());
                    return studentRepository.save(student);
                })
                .orElse(null);
    }

    // Delete student by ID
    public boolean deleteStudent(Long id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.delete(student);
            return true;
        }).orElse(false);
    }

    // Delete all students
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
