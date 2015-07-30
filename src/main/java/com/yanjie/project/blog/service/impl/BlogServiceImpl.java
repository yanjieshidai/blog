package com.yanjie.project.blog.service.impl;

import com.yanjie.project.blog.bean.AjaxResult;
import com.yanjie.project.blog.bean.convert.BlogConvert;
import com.yanjie.project.blog.bean.convert.DocConvert;
import com.yanjie.project.blog.bean.param.SearchParam;
import com.yanjie.project.blog.bean.po.BlogPO;
import com.yanjie.project.blog.bean.po.DocPO;
import com.yanjie.project.blog.bean.vo.BlogVO;
import com.yanjie.project.blog.bean.vo.DocVO;
import com.yanjie.project.blog.dao.IBlogDAO;
import com.yanjie.project.blog.dao.IDocDAO;
import com.yanjie.project.blog.service.IBlogService;
import com.yanjie.project.blog.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * Description: IBlogServiceImpl
 * Author: wangjie12
 * Create: 2015-07-19
 */
@Component
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogDAO blogDAO;

    @Autowired
    private IDocDAO docDAO;

    @Override
    public List<BlogVO> list(SearchParam param) {
        List<BlogPO> blogPOList = blogDAO.queryAll();
        List<BlogVO> blogVOList = BlogConvert.convertVOListFromPOList(blogPOList);
        return blogVOList;
    }

    @Override
    public BlogVO getBlog(SearchParam param) {
        Long id = param.getId();
        BlogPO blogPO = blogDAO.queryById(id);
        BlogVO blogVO = BlogConvert.convertVOFromPO(blogPO);
        return blogVO;
    }

    @Override
    public AjaxResult<DocVO> createDoc(DocVO docVO) {
        AjaxResult<DocVO> result = new AjaxResult<>();
        DocPO tmp = new DocPO();
        tmp.setTitle("第一个文档");
        tmp.setContext("这是一个测试~");
        UUID uuid = UUID.randomUUID();
        tmp.setUuid(uuid.toString());
        tmp.setCreator(UserUtil.getUserId());
        docVO.setDocPO(tmp);

        DocPO docPO = docDAO.create(docVO.getDocPO());
        if (docPO != null) {
            docVO.setDocPO(docPO);
            result.setSuccess(true);
            result.setData(docVO);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public List<DocVO> listDoc(SearchParam param) {
        List<DocPO> docPOList = docDAO.queryAll();
        List<DocVO> docVOList = DocConvert.convertVOListFromPOList(docPOList);
        return docVOList;
    }

    @Override
    public DocVO getDoc(SearchParam param) {
        DocPO docPO = null;
        if (param.getId() != null) {
            docPO = docDAO.queryById(param.getId());
        }
        DocVO docVO = DocConvert.convertVOFromPO(docPO);
        return docVO;
    }
}
