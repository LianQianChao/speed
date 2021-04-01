package org.app.speed.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.app.speed.constant.enums.StatusEnum;
import org.app.speed.exception.DefinitionException;
import org.springframework.stereotype.Component;

/**
 * 构建统一请求响应结果
 *
 * @author Lian.QianChao
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class ResultUtil<T> {

    //状态码
    public Integer code;

    //提示信息
    public String message;

    //数据
    public  T data;


    /**
     * 自定义异常返回的结果
     */
    public ResultUtil<T> defineError(DefinitionException de){
        return new ResultUtil<>(de.getCode(),de.getMessage(),null);
    }

    /**
     * 处理其他异常
     * @param statusEnum 状态
     */
    public ResultUtil<T> otherError(StatusEnum statusEnum){
        return success(statusEnum);
    }


    /**
     * 返回成功结果
     */
    public ResultUtil<T> success(){
        return success(StatusEnum.SUCCESS,null);
    }

    /**
     * 返回成功结果, 封装数据
     * @param data 数据
     */
    public ResultUtil<T> success(T data){
        return success(StatusEnum.SUCCESS,data);
    }


    /**
     * 返回成功结果，自定义状态码，不包含数据
     * ç
     */
    public ResultUtil<T> success(StatusEnum statusEnum){
        return success(statusEnum, null);
    }


    /**
     * 返回成功结果，自定义状态码，包含数据
     * @param statusEnum 状态
     * @param data 数据
     */
    public ResultUtil<T> success(StatusEnum statusEnum, T data){
        return new ResultUtil<>(statusEnum.getCode(),statusEnum.getMessage(),data);
    }



}
