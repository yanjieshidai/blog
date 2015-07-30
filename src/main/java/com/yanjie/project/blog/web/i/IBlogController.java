package com.yanjie.project.blog.web.i;

import com.yanjie.project.blog.bean.param.SearchParam;
import com.yanjie.project.blog.bean.vo.BlogVO;
import com.yanjie.project.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public List<BlogVO> list(SearchParam param) {
        List<BlogVO> blogVOList = blogService.list(param);
        return blogVOList;
    }
}
