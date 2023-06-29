package organ.kosa.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import organ.kosa.springbootdeveloper.domain.Article;
import organ.kosa.springbootdeveloper.dto.ArticleAddRequestDto;
import organ.kosa.springbootdeveloper.dto.ArticleResponseDto;
import organ.kosa.springbootdeveloper.repository.ArticleRepository;
import organ.kosa.springbootdeveloper.service.ArticleService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody ArticleAddRequestDto dto) {
        Article savedArticle = articleService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponseDto>> findAllArticles() {
        List<ArticleResponseDto> dtos = articleService.findAll()
                .stream()
                .map(article -> new ArticleResponseDto(article))
                .toList();
        return ResponseEntity.ok()
                .body(dtos);
    }
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponseDto> findArticle(@PathVariable long id) {
        Article article = articleService.findById(id);
        return ResponseEntity.ok()
                .body(new ArticleResponseDto(article));
    }
}
