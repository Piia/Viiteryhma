package viiteryhma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viiteryhma.model.Book;
 
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}