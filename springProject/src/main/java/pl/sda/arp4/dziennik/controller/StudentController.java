package pl.sda.arp4.dziennik.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.arp4.dziennik.model.Student;
import pl.sda.arp4.dziennik.model.dto.StudentRequest;
import pl.sda.arp4.dziennik.model.dto.StudentDTO;
import pl.sda.arp4.dziennik.service.StudentService;

import java.util.List;

@Slf4j
@RequestMapping("/api/dziennik")
@RestController
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;


    @GetMapping("/list")
    public List<StudentDTO> studentList() {
        log.info("Wywołano metodę studentList");
        return studentService.findAll();
    }

    @PostMapping("/add")
    public void addStudent (@RequestBody StudentRequest request) {
        log.info("Wywołano metodę addStudent " + request);
        studentService.addStudent(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long studentId) {
        log.info("Wywołano metodę: delete " + studentId);
        studentService.deleteStudent(studentId);
    }

    @PatchMapping("/update/{id}")
    public void update(@PathVariable(name = "id") Long studentId, @RequestBody Student student) {
        log.info("Wywołano metodę: update -> " + student);
        studentService.update(studentId, student);
    }
}

