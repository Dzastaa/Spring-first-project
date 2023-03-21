package pl.sda.arp4.dziennik.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.sda.arp4.dziennik.model.dto.StudentDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String indexNumber;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<Rating> grades;

    public Student(String name, String surname, LocalDate birthDate, String indexNumber) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.indexNumber = indexNumber;
    }

    public StudentDTO mapToStudentDTO() {
    return new StudentDTO(
            id,
            name,
            surname,
            birthDate,
            indexNumber
    );
    }
}

