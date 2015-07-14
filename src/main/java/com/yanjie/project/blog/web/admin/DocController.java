package com.yanjie.project.blog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangjie12 on 15-7-6.
 */
@Controller
@RequestMapping("admin/doc")
public class DocController {

    @RequestMapping("/upload")
    @ResponseBody
    public String upload() {
        return "ok";
    }

    @RequestMapping("re-upload")
    @ResponseBody
    public String reUpload() {
        return "ok";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String list() {
        return "ok";
    }


    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        return "ok";
    }

    @RequestMapping("/publish")
    @ResponseBody
    public String publish() {
        return "ok";
    }


}
