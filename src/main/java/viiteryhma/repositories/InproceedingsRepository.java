package viiteryhma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viiteryhma.model.Inproceedings;
 
@Repository
public interface InproceedingsRepository extends JpaRepository<Inproceedings, Long> {
}