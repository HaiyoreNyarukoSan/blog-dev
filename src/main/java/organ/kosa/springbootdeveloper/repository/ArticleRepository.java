package organ.kosa.springbootdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import organ.kosa.springbootdeveloper.domain.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
