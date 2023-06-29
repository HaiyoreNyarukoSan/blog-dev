package organ.kosa.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import organ.kosa.springbootdeveloper.domain.Article;
import organ.kosa.springbootdeveloper.dto.ArticleAddRequestDto;
import organ.kosa.springbootdeveloper.repository.ArticleRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    public Article save(ArticleAddRequestDto dto) {
        return articleRepository.save(dto.toEntity());
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));
    }
}
