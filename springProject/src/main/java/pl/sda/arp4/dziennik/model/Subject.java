package pl.sda.arp4.dziennik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sda.arp4.dziennik.model.dto.SubjectDTO;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;


    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Rating> grades;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }
    public SubjectDTO mapToSubjectDTO() {
        return new SubjectDTO(
                subjectName
        );
    }
}
