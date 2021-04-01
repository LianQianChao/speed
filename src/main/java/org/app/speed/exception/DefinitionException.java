package org.app.speed.exception;

import lombok.Getter;
import lombok.Setter;
import org.app.speed.constant.enums.StatusEnum;

/**
 * 自定义异常
 */
@Getter
@Setter
public final class DefinitionException extends RuntimeException {

    //状态码
    public Integer code;

    //提示信息
    public String message;

    /**
     * 构建异常信息
     *
     * @param statusEnum 状态枚举
     */
    public DefinitionException(StatusEnum statusEnum) {
        this.code = statusEnum.getCode();
        this.message = statusEnum.getMessage();
    }

}
