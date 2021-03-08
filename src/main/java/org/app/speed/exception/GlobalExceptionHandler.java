package org.app.speed.exception;

import org.app.speed.constant.enums.StatusEnum;
import org.app.speed.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     * @return
     */
    @ExceptionHandler(value = DefinitionException.class)
    public ResultUtil defineExceptionHandler(DefinitionException de){
        return ResultUtil.defineError(de);
    }

    /**
     * 处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultUtil exceptionHandler(Exception e){
        return ResultUtil.otherError(StatusEnum.INTERNAL_SERVER_ERROR);
    }

}
