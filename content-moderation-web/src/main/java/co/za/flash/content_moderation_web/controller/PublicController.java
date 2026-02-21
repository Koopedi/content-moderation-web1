package co.za.flash.content_moderation_web.controller;

import co.za.flash.content_moderation_web.service.SensitiveWordWebService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class PublicController {

    private final SensitiveWordWebService service;

    @GetMapping("/")
    public String sanitizePage() {
        return "public/sanitize";
    }

    @PostMapping("/sanitize")
    public String sanitize(@RequestParam String text,
                           Model model) {

        String result = service.sanitize(text);

        model.addAttribute("inputText", text);
        model.addAttribute("result", result);

        return "public/sanitize";
    }
}
