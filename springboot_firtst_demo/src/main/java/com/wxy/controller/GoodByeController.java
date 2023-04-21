package com.wxy.controller;

import com.wxy.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goodbye")
public class GoodByeController {

    @GetMapping
    public Result hello(){
        return Result.success("GoodBye！");
    }
}
