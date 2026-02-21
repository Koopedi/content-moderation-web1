package co.za.flash.content_moderation_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class WordResponse {

        private Long id;
        private String word;
        private String message;

}
