package org.app.speed.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.app.speed.constant.enums.StatusEnum;
import org.app.speed.exception.DefinitionException;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResultUtil<T> {

    //状态码
    private Integer code;

    //提示信息
    private String message;

    //数据
    private T data;

    /**
     * 自定义异常返回的结果
     */
    public static ResultUtil defineError(DefinitionException de){
        return new ResultUtil(de.getCode(),de.getMessage(),null);
    }

    /**
     * 处理其他异常
     * @param statusEnum 状态
     */
    public static ResultUtil otherError(StatusEnum statusEnum){
        return success(statusEnum);
    }


    /**
     * 返回成功结果
     */
    public static ResultUtil success(){
        return success(StatusEnum.SUCCESS);
    }

    /**
     * 返回成功结果, 封装数据
     * @param object 数据
     */
    public static ResultUtil success(Object object){
        return success(StatusEnum.SUCCESS,object);
    }


    /**
     * 返回成功结果，自定义状态码，不包含数据
     * ç
     */
    public static ResultUtil success(StatusEnum statusEnum){
        return success(statusEnum, null);
    }


    /**
     * 返回成功结果，自定义状态码，包含数据
     * @param statusEnum 状态
     * @param object 数据
     */
    public static ResultUtil success(StatusEnum statusEnum, Object object){
        return new ResultUtil(statusEnum.getCode(),statusEnum.getMessage(),object);
    }

}
