//package co.za.flash.content_moderation_web.controller;
//
//import co.za.flash.content_moderation_web.model.WordResponse;
//import co.za.flash.content_moderation_web.service.SensitiveWordWebService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//@RequiredArgsConstructor
//public class WebController {
//
//    private final SensitiveWordWebService service;
//
//    @GetMapping("/")
//    public String home(Model model) {
//        model.addAttribute("words", service.getAll());
//        return "index";
//    }
//
////    @PostMapping("/add")
////    public String add(@RequestParam String word) {
////        service.add(word);
////        return "redirect:/";
////    }
//
//
//    @PostMapping("/add")
//    public String add(@RequestParam String word,
//                      RedirectAttributes redirectAttributes) {
//
//        WordResponse response = service.add(word);
//
//        if ("Word already exists".equalsIgnoreCase(response.getMessage())) {
//            redirectAttributes.addFlashAttribute("error", response.getMessage());
//        } else {
//            redirectAttributes.addFlashAttribute("success", response.getMessage());
//        }
//
//        return "redirect:/";
//    }
//
//
//    @PostMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        service.delete(id);
//        return "redirect:/";
//    }
//
//    @PostMapping("/sanitize")
//    public String sanitize(@RequestParam String text, Model model) {
//        model.addAttribute("words", service.getAll());
//        model.addAttribute("result", service.sanitize(text));
//        model.addAttribute("inputText", text);
//        return "index";
//    }
//}