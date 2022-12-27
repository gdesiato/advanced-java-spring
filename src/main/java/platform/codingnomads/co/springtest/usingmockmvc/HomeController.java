package platform.codingnomads.co.springtest.usingmockmvc;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @ResponseBody //it transforms the specific
    public String greet() {
        return "Hello Back";
    }

    @PostMapping("/test_1")
    @ResponseBody
    public ResponseEntity<String> performTest_1(){
        return ResponseEntity.ok()
                .header("X-header", "header value 1")
                //.header("X-header", "header value 2")
                .body("test 1 confirmation");
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
