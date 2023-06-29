package organ.kosa.springbootdeveloper.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import organ.kosa.springbootdeveloper.domain.Article;

import java.util.Locale;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleAddRequestDto {
    private String title;
    private String content;

    public Article toEntity() {
        return Article.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}