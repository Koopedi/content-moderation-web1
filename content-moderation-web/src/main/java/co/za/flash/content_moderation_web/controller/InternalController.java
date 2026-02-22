package co.za.flash.content_moderation_web.controller;

import co.za.flash.content_moderation_web.model.WordResponse;
import co.za.flash.content_moderation_web.service.SensitiveWordWebService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/internal")
@RequiredArgsConstructor
public class InternalController {

    private final SensitiveWordWebService service;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("words", service.getAll());
        return "internal/dashboard";
    }

    @PostMapping("/add")
    public String add(@RequestParam String word,
                      RedirectAttributes redirectAttributes) {

        WordResponse response = service.add(word);

        if (response.getId() == null) {
            redirectAttributes.addFlashAttribute("error", response.getMessage());
        } else {
            redirectAttributes.addFlashAttribute("success", response.getMessage());
        }

        return "redirect:/internal/dashboard";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String word,
                         RedirectAttributes redirectAttributes) {

        WordResponse response = service.update(id, word);

        if (response.getMessage() != null &&
                response.getMessage().equalsIgnoreCase("Word already exists")) {

            redirectAttributes.addFlashAttribute("error", response.getMessage());
        } else {
            redirectAttributes.addFlashAttribute("success", response.getMessage());
        }

        return "redirect:/internal/dashboard";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirectAttributes) {

        service.delete(id);
        redirectAttributes.addFlashAttribute("success", "Word deleted successfully");

        return "redirect:/internal/dashboard";
    }
}