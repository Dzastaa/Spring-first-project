package pl.sda.arp4.dziennik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import pl.sda.arp4._spring_dziennik.model.Grade;
import pl.sda.arp4.dziennik.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
