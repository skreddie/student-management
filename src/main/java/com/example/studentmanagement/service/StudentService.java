package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.StudentRequestDTO;
import com.example.studentmanagement.dto.StudentResponseDTO;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());

        Student saved = repository.save(student);

        return new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getCourse()
        );
    }

    public List<StudentResponseDTO> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(s -> new StudentResponseDTO(
                        s.getId(),
                        s.getName(),
                        s.getEmail(),
                        s.getCourse()
                ))
                .toList();
    }

    public StudentResponseDTO getStudentById(Long id) {
        Student s = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        return new StudentResponseDTO(
                s.getId(),
                s.getName(),
                s.getEmail(),
                s.getCourse()
        );
    }

    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        existingStudent.setName(dto.getName());
        existingStudent.setEmail(dto.getEmail());
        existingStudent.setCourse(dto.getCourse());

        Student updated = repository.save(existingStudent);

        return new StudentResponseDTO(
                updated.getId(),
                updated.getName(),
                updated.getEmail(),
                updated.getCourse()
        );
    }

    public void deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
