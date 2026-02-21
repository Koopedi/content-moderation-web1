package co.za.flash.content_moderation_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Word {
    private Long id;
    private String word;
}
