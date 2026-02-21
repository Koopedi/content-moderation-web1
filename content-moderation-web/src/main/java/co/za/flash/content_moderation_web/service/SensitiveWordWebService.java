package co.za.flash.content_moderation_web.service;

import co.za.flash.content_moderation_web.model.Word;
import co.za.flash.content_moderation_web.model.WordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensitiveWordWebService {
    private final WebClient webClient;

    public List<Word> getAll() {
        return webClient.get()
                .uri("/words")
                .retrieve()
                .bodyToFlux(Word.class)
                .collectList()
                .block();
    }

    public WordResponse add(String word) {
        return webClient.post()
                .uri("/words")
                .bodyValue(new Word(null, word))
                .retrieve()
                .bodyToMono(WordResponse.class)
                .block();
    }


//    public void add(String word) {
//        webClient.post()
//                .uri("/words")
//                .bodyValue(new Word(null, word))
//                .retrieve()
//                .bodyToMono(Void.class)
//                .block();
//    }


    public void delete(Long id) {
        webClient.delete()
                .uri("/words/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public String sanitize(String text) {
        return webClient.post()
                .uri("/sanitize")
                .bodyValue(new TextRequest(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    record TextRequest(String text) {}
}
