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
     *
     * @return ResultUtil<Object>
     */
    @ExceptionHandler(value = DefinitionException.class)
    public ResultUtil<Object> defineExceptionHandler(DefinitionException de) {
        return new ResultUtil<>().defineError(de);
    }

    /**
     * 处理其他异常
     *
     * @param e Exception
     * @return ResultUtil<Object>
     */
    @ExceptionHandler(value = Exception.class)
    public ResultUtil<Object> exceptionHandler(Exception e) {
        e.printStackTrace();
        return new ResultUtil<>().otherError(StatusEnum.INTERNAL_SERVER_ERROR);
    }

}
