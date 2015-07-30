package com.yanjie.project.blog.web.i;

import com.yanjie.project.blog.bean.param.SearchParam;
import com.yanjie.project.blog.bean.vo.BlogVO;
import com.yanjie.project.blog.bean.vo.DocVO;
import com.yanjie.project.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wangjie12 on 15-7-6.
 */

@Controller
@RequestMapping("/i/blog")
public class IBlogController {


    @Autowired
    private IBlogService blogService;

    @RequestMapping({"/", "/list"})
    public ModelAndView list(SearchParam param) {
        ModelAndView mv = new ModelAndView();
        List<BlogVO> blogVOList = blogService.list(param);
        mv.addObject("blogs",blogVOList);
        mv.setViewName("/i/list");
        return mv;
    }

    @RequestMapping( "/{id}")
    public ModelAndView blog(@PathVariable Long id,SearchParam param) {
        ModelAndView mv =new ModelAndView();
        param.setId(id);
        BlogVO blog= blogService.getBlog(param);
        mv.setViewName("/i/blog");
        mv.addObject("blog",blog);
        return mv;
    }

}
