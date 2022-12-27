package platform.codingnomads.co.springtest.usingmockmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Bobbert");
        return "greeting";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String greet() {
        return "Hello Back";
    }

    @GetMapping("/test_1")
    public String performTest_1(){
        return "testing test 1";
    }

    @GetMapping("/test_2")
    public String performTest_2(){
        return "testing test 2";
    }

    @GetMapping("/test_3")
    public String performTest_3(){
        return "testing test 3";
    }
}
