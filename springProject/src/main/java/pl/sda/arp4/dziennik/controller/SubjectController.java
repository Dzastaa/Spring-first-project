package pl.sda.arp4.dziennik.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.arp4.dziennik.model.dto.SubjectRequest;
import pl.sda.arp4.dziennik.model.dto.SubjectDTO;
import pl.sda.arp4.dziennik.service.SubjectService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor

public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/add")
    public void create(@RequestBody SubjectRequest request) {
        log.info("Wywołano metodę create dla: " + request);
        subjectService.create(request);
    }

    @GetMapping("/list")
    public List<SubjectDTO> subjectList() {
        log.info("Wywołano metodę subjectList");
        return subjectService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long subjectId) {
        log.info("Wywołano metodę: delete " + subjectId);
        subjectService.deleteSubject(subjectId);
    }
}
