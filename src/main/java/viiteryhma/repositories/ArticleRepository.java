package viiteryhma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viiteryhma.model.Article;

/**
 * @author Piia Hartikka
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}