package pl.sda.arp4.dziennik.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String indexNumber;
}
