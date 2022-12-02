package platform.codingnomads.co.springmvc.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class GreetingController {

    @GetMapping({ "/practice" })
    public String index1(Model model) {
        model.addAttribute("name", "myself");
        model.addAttribute("action", "practicing");
        model.addAttribute("what", "method/endpoint creation");
        return "practice";
    }

    @GetMapping({ "/", "/index" })
    public String index(Model model) {
        model.addAttribute("name", "Spring Developer!");
        return "greeting"; 
    }

    @GetMapping("/subjects")
    public String subjects(Model model) {
        Subject s1 = new Subject("Java", "Programming");
        Subject s2 = new Subject("Python", "Programming");
        Subject s3 = new Subject("Geometry", "Math");

        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(s1);
        subjects.add(s2);
        subjects.add(s3);

        model.addAttribute("subjects", subjects);
        return "subjects";
    }
}