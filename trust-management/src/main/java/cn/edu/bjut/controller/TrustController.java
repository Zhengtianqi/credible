package cn.edu.bjut.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrustController {
    @RequestMapping("/index")
    public String index() {
        return "keep running";
    }
}
