package pl.sda.arp4.dziennik.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RatingRequest {
    private Double value;
    private LocalDateTime dateAdded;
}
