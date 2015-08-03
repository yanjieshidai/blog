package com.yanjie.project.blog.service.impl;

import com.yanjie.project.blog.bean.result.AjaxResult;
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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Description: IBlogServiceImpl
 * Author: wangjie12
 * Create: 2015-07-19
 */
@Service
public class BlogServiceImpl implements IBlogService {
    @Resource
    private IBlogDAO blogDAO;

    @Resource
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
//        tmp.setCreator(UserUtil.getUserId(request));
        docVO.setDocPO(tmp);

        DocPO docPO = docDAO.insert(docVO.getDocPO());
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

    public AjaxResult<BlogVO> createBlog(DocPO doc) {
        BlogPO blogPO = BlogConvert.convertFromDoc(doc);
        blogPO = blogDAO.insert(blogPO);
        AjaxResult result = new AjaxResult();
        if (blogPO != null) {
            result.setSuccess(false);
            return result;
        } else {
            result.setSuccess(true);
            result.setData(BlogConvert.convertVOFromPO(blogPO));
            return result;
        }
    }

    @Override
    public AjaxResult<BlogVO> publisDoc(SearchParam param) {
        AjaxResult<BlogVO> result = new AjaxResult<>();
        result.setSuccess(false);
        result.setMessage("发布失败!");
        if (param.getId() == null) {
            result.setMessage(result.getMessage() + "id is null.");
            return result;
        }
        DocPO doc = docDAO.queryById(param.getId());
        return publish(doc);
    }

    private AjaxResult<BlogVO> publish(DocPO doc) {
        AjaxResult<BlogVO> result = new AjaxResult<>();
        result.setSuccess(false);
        result.setMessage("发布失败!");
        if (doc == null) {
            result.setMessage(result.getMessage() + "找不到对应的文档。");
            return result;
        }
        BlogPO blogPO = blogDAO.queryByDocId(doc.getId());
        if (blogPO == null) {
            AjaxResult<BlogVO> blog = createBlog(doc);
            if (blog.isSuccess()) {
                result.setMessage("发布成功");
                result.setSuccess(true);
                result.setData(blog.getData());
                return result;
            } else {
                return result;
            }
        }
        BlogPO blog = BlogConvert.convertFromDoc(doc);
        blog.setId(blogPO.getId());
        boolean flag = blogDAO.updateBlogById(blog);
        if (flag) {
            result.setSuccess(true);
            result.setMessage("发布成功！");
            result.setData(BlogConvert.convertVOFromPO(blogPO));
        }
        return result;
    }
}
