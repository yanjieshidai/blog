package com.wj.project.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangjie12 on 15-7-6.
 */

@Controller
@RequestMapping("/doc")
public class CDocController {


    @RequestMapping("list")
    public String list(){
        return "ok";
    }
}
