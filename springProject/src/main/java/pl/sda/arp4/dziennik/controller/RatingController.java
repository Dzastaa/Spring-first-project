package pl.sda.arp4.dziennik.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
//import pl.sda.arp4._spring_dziennik.model.Grade;
import pl.sda.arp4.dziennik.model.Rating;
import pl.sda.arp4.dziennik.model.dto.RatingRequest;
import pl.sda.arp4.dziennik.service.GradeService;

import java.util.List;


@Slf4j
@RequestMapping("/api/rating")
@RestController
@RequiredArgsConstructor

public class RatingController {

    private final GradeService gradeService;



    @PostMapping("/add")
    public void addGrade(@RequestParam Long studentId, Long subjectId, @RequestBody RatingRequest request) {
        log.info("Wywołano metodę addGrade");
        gradeService.addGrade(studentId, subjectId, request);
    }

    @GetMapping("/list")
    public List<Rating> allGradesList(@RequestParam Long studentId) {
        log.info("Wywołano metodę RatingList");
        return gradeService.allGradesList(studentId);
    }
    @GetMapping("/subject/list")

    public List<Rating> subjectGradesList(@RequestParam Long studentId, Long subjectId) {
        log.info("Wywołano metodę gradeList");
        return gradeService.subjectGradesList(studentId,subjectId);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long studentId, Long subjectId, Long gradeId) {
        log.info("Wywołano metodę: delete " + gradeId);
        gradeService.deleteGrade(gradeId, studentId, subjectId);
    }

    @PatchMapping("/update/{id}")
    public void update(@PathVariable(name = "id") Long studentId, Long subjectId, Long gradeId, @RequestBody Rating grade) {
        log.info("Wywołano metodę: update -> " + grade);
        gradeService.update(studentId, subjectId, gradeId, grade);
    }

}
