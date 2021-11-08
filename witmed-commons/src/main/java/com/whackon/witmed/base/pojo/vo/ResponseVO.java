package com.whackon.witmed.base.pojo.vo;

import com.whackon.witmed.base.pojo.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * <b>系统响应视图信息</b>
 * <p>
 *     系统响应视图信息设置了如下属性：
 *     1、系统响应码：code<br/>
 *     2、系统响应数据：data<br/>
 *     所有返回前端数据<b>都必须以本系统响应视图信息返回</b>。
 * </p>
 * @param <E>
 *
 * @author He'l'lo'World
 * @version 1.0.0
 * @since 1.0.0
 */
public class ResponseVO<E> implements Serializable {
    private static final long serialVersionUID = -1243700449847575050L;
    private Integer code;                        // 系统响应码
    private E data;                             // 系统响应数据

    private ResponseVO(Integer code, E data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    /**
     * <b>获得系统响应业务处理成功视图信息</b>
     * @return
     */
    public static ResponseVO getSuccessResponseVO() {
        return new ResponseVO(ResponseCodeEnum.RESPONSE_ERROR.getCode(),
                ResponseCodeEnum.RESPONSE_SUCCESS.getRemark());
    }

    /**
     * <b>获得系统响应业务处理成功视图信息</b>
     * @param data
     * @return
     */
    public static ResponseVO getSuccessResponseVO(Object data) {
        return new ResponseVO(ResponseCodeEnum.RESPONSE_SUCCESS.getCode(), data);
    }

    /**
     * <b>获得用户未认证视图信息</b>
     * @return
     */
    public static ResponseVO getUnauthResponseVO() {
        return new ResponseVO(ResponseCodeEnum.RESPONSE_UNAUTH.getCode(),
                ResponseCodeEnum.RESPONSE_UNAUTH.getRemark());
    }

    /**
     * <b>获得系统业务流程处理错误视图信息</b>
     * @param errorMsg
     * @return
     */
    public static ResponseVO getErrorResponseVO(String errorMsg) {
        return new ResponseVO(ResponseCodeEnum.RESPONSE_EXCEPTION.getCode(), errorMsg);
    }

    /**
     * <b>获得系统响应异常视图信息</b>
     * @param e
     * @return
     */
    public static ResponseVO getExceptionResponseVO(Exception e) {
        return new ResponseVO(ResponseCodeEnum.RESPONSE_EXCEPTION.getCode(), e.getMessage());
    }
}
