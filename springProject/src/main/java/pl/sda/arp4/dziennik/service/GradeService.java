package pl.sda.arp4.dziennik.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arp4.dziennik.exception.WithoutParamException;
//import pl.sda.arp4._spring_dziennik.model.Grade;
import pl.sda.arp4.dziennik.model.Rating;
import pl.sda.arp4.dziennik.model.Student;
import pl.sda.arp4.dziennik.model.Subject;
import pl.sda.arp4.dziennik.model.dto.RatingRequest;
import pl.sda.arp4.dziennik.repository.RatingRepository;
import pl.sda.arp4.dziennik.repository.StudentRepository;
import pl.sda.arp4.dziennik.repository.SubjectRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor

public class GradeService {

    private final RatingRepository ratingRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;


    public void addGrade(Long studentId, Long subjectId, RatingRequest request) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);

        if (optionalStudent.isPresent() && optionalSubject.isPresent()) {
            Student student = optionalStudent.get();
            Subject subject = optionalSubject.get();

            Rating newGrade = new Rating();
            newGrade.setValue(request.getValue());
            newGrade.setStudent(student);
            newGrade.setSubject(subject);

            ratingRepository.save(newGrade);
            return;
        }
        throw new EntityNotFoundException("Nie znaleziono studenta lub przedmiotu");
    }

    public List<Rating> allGradesList(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            List<Rating> gradesList = new ArrayList<>(student.getGrades());

            return gradesList;
        }
        throw new EntityNotFoundException("Nie znaleziono studenta o id: " + studentId);
    }


    public List<Rating> subjectGradesList(Long studentId, Long subjectId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Subject> subjectOptional = subjectRepository.findById(subjectId);

        if (studentOptional.isPresent() && subjectOptional.isPresent()) {
            Student student = studentOptional.get();
            Subject subject = subjectOptional.get();

            List<Rating> ocenyStudenta = new ArrayList<>(student.getGrades());
            List<Rating> ocenyStudentaZprzedmiotu = new ArrayList<>();
            for (Rating grades : ocenyStudenta) {
                if (grades.getSubject().getId() == subjectId) {
                    ocenyStudentaZprzedmiotu.add(grades);
                }
            }
            return ocenyStudentaZprzedmiotu;
        }
        throw new EntityNotFoundException("Nie odnaleziono wskazanego studenta lub przedmiotu");
    }

    public void deleteGrade(Long studentId, Long subjectId, Long gradeId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        Optional<Rating> optionalGrade = ratingRepository.findById(gradeId);
        if (optionalStudent.isPresent() && optionalSubject.isPresent() && optionalGrade.isPresent()) {
            Student student = optionalStudent.get();
            Subject subject = optionalSubject.get();
            Rating grade = optionalGrade.get();

            ratingRepository.deleteById(gradeId);
            return;
        }
        throw new WithoutParamException("Nie ma oceny spełeniającej podane kryteria: " + studentId + subjectId + gradeId);
    }

    public void update(Long studentId, Long subjectId, Long gradeId, Rating editedGrade) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        Optional<Rating> optionalGrade = ratingRepository.findById(gradeId);

        if (studentOptional.isPresent() && optionalSubject.isPresent() && optionalGrade.isPresent()) {
            Student student = studentOptional.get();
            Subject subject = optionalSubject.get();
            Rating grade = optionalGrade.get();

            if(editedGrade.getValue()!=null){
                grade.setValue(editedGrade.getValue());
            }
            ratingRepository.save(grade);
            return;
        }
        throw new EntityNotFoundException("Nie odnaleziono oceny spełniającej podane kryteria: " + studentId + subjectId + gradeId);
    }
    }