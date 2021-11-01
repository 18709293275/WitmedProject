package com.whackon.witmed.base.pojo.vo;

import com.whackon.witmed.base.util.BaseConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <b>系统分页视图信息</b>
 * <p>
 *     系统分页视图信息设置了以下相关分页信息：<br/>
 *     1、当前页码：pageNum<br/>
 *     2、每页显示数量：pageSize<br/>
 *     3、分页列表：list<br/>
 *     4、总数量：totalSize<br/>
 *     5、总页数：totalPages<br/>
 *     所有需要返回前端分页信息<b>都必须以本系统分页视图信息的形式返回</b>。
 * </p>
 * @param <E>
 *
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel(value = "系统分页视图信息")
public class PageVO<E extends BaseVO> implements Serializable {
    private static final long serialVersionUID = -3458922961994208370L;
    @ApiModelProperty(value = "当前页码")
    private Integer pageNum;                        // 当前页码
    @ApiModelProperty(value = "每页显示数量")
    private Integer pageSize;                       // 每页显示数量
    @ApiModelProperty(value = "分页列表")
    private List<E> list;                           // 分页列表
    @ApiModelProperty(value = "总数量")
    private Long totalSize;                         // 总数量
    @ApiModelProperty(value = "总页数")
    private Integer totalPages;                     // 总页数

    public PageVO() {}

    public PageVO(Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageNum > 0) {
            this.pageNum = pageNum;
        } else {
            this.pageNum = BaseConstants.PAGE_NUM;
        }

        if (pageSize != null && pageSize > 0) {
            this.pageSize = pageSize;
        } else {
            this.pageSize = BaseConstants.PAGE_SIZE;
        }
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
