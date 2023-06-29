package organ.kosa.springbootdeveloper.dto;

import lombok.Getter;
import organ.kosa.springbootdeveloper.domain.Article;

@Getter
public class ArticleResponseDto {
    private final String title;
    private final String content;
    public ArticleResponseDto(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
