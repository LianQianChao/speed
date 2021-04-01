package org.app.speed.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum StatusEnum {
    SUCCESS(200, "成功"),
    NO_AUTH(401, "未授权"),
    NO_PERMISSION(403, "没有权限"),
    NOT_FOUND(400, "未找到该资源"),
    INTERNAL_SERVER_ERROR(500, "服务错误");

    //状态码
    private Integer code;

    //信息
    private String message;

}
