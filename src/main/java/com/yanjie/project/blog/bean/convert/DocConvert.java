package com.yanjie.project.blog.bean.convert;

import com.yanjie.project.blog.bean.po.DocPO;
import com.yanjie.project.blog.bean.vo.DocVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: BlogConvert
 * Author: wangjie12
 * Create: 2015-07-14
 */
public class DocConvert {
    public static DocVO convertVOFromPO(DocPO po) {
        if (po == null) {
            return null;
        }
        DocVO vo = new DocVO();
        vo.setDocPO(po);
        return vo;
    }

    public static List<DocVO> convertVOListFromPOList(List<DocPO> poList) {
        if (poList == null) {
            return null;
        }
        List<DocVO> docVOList = new ArrayList<>(poList.size());
        for (DocPO docPO : poList) {
            docVOList.add(convertVOFromPO(docPO));
        }
        return docVOList;
    }
}
