package co.za.flash.content_moderation_web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWordRequest {
//    @NotBlank(message = "Word cannot be blank")
//    @Size(max = 100, message = "Word cannot exceed 100 characters")
    private String word;
}
