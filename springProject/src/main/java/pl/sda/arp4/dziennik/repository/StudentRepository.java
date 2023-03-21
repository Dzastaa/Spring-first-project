package pl.sda.arp4.dziennik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arp4.dziennik.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
