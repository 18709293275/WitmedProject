package com.whackon.witmed.base.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <b>系统查询分页视图信息</b>
 * @param <E>
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "系统查询分页视图信息")
public class QueryPageVO<E extends BaseVO> implements Serializable {
    private static final long serialVersionUID = -7051580131896636576L;
    @ApiModelProperty(value = "查询视图")
    private E queryVO;                      // 查询视图
    @ApiModelProperty(value = "分页视图")
    private PageVO<E> pageVO;               // 分页视图

    public QueryPageVO() {}

    public QueryPageVO(E queryVO, PageVO<E> pageVO) {
        this.queryVO = queryVO;
        this.pageVO = pageVO;
    }

    public QueryPageVO(E queryVO, Integer pageNum, Integer pageSize) {
        this.queryVO = queryVO;
        this.pageVO = new PageVO<E>(pageNum, pageSize);
    }

    public E getQueryVO() {
        return queryVO;
    }

    public void setQueryVO(E queryVO) {
        this.queryVO = queryVO;
    }

    public PageVO<E> getPageVO() {
        return pageVO;
    }

    public void setPageVO(PageVO<E> pageVO) {
        this.pageVO = pageVO;
    }
}
