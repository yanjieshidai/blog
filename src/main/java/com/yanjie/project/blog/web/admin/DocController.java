package com.yanjie.project.blog.web.admin;

import com.yanjie.project.blog.bean.AjaxResult;
import com.yanjie.project.blog.bean.vo.DocVO;
import com.yanjie.project.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangjie12 on 15-7-6.
 */
@Controller
@RequestMapping("admin/doc")
public class DocController {

    @Autowired
    private IBlogService blogService;

    @RequestMapping("/upload")
    @ResponseBody
    public AjaxResult upload(DocVO docVO) {
        AjaxResult<DocVO> ajaxResult = blogService.createDoc(docVO);
        return ajaxResult;
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
