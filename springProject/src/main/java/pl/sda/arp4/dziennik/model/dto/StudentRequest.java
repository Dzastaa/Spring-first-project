package pl.sda.arp4.dziennik.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentRequest {
    private String studentName;
    private String studentSurname;
    private LocalDate birthDate;
    private String studentIndexNumber;

}
