package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(path = "/1", method = RequestMethod.GET)
    String get() { return "Hello from get"; }

    @RequestMapping(path = "/2", method = RequestMethod.DELETE)
    String delete() { return "Hello from delete"; }

    @RequestMapping(path = "/3", method = RequestMethod.POST)
    String post() { return "Hello from post"; }

    @RequestMapping(path = "/4", method = RequestMethod.PUT)
    String put() {
        return "Hello from put";
    }

    @RequestMapping(path = "/5", method = RequestMethod.PATCH)
    String patch() {
        return "Hello from patch";
    }
}
