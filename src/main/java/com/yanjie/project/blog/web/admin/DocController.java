package com.yanjie.project.blog.web.admin;

import com.yanjie.project.blog.bean.result.AjaxResult;
import com.yanjie.project.blog.bean.param.SearchParam;
import com.yanjie.project.blog.bean.vo.BlogVO;
import com.yanjie.project.blog.bean.vo.DocVO;
import com.yanjie.project.blog.service.IBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by wangjie12 on 15-7-6.
 */
@Controller
@RequestMapping("admin/doc")
public class DocController {

    @Resource
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

    @RequestMapping({"/", "/list"})
    public ModelAndView list(SearchParam param) {
        ModelAndView mv = new ModelAndView();
        List<DocVO> docVOList = blogService.listDoc(param);
        mv.addObject("docs", docVOList);
        mv.setViewName("/admin/list");
        return mv;
    }

    @RequestMapping({"/{id}"})
    public ModelAndView doc(@PathVariable Long id, SearchParam param) {
        ModelAndView mv = new ModelAndView();
        param.setId(id);
        DocVO docVO = blogService.getDoc(param);
        mv.addObject("doc", docVO);
        mv.setViewName("/admin/doc");
        return mv;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        return "ok";
    }

    @RequestMapping("/publish")
    @ResponseBody
    public AjaxResult publish(SearchParam param) throws IOException {
        AjaxResult<BlogVO> ajaxResult = blogService.publisDoc(param);
        return ajaxResult;
    }


}
