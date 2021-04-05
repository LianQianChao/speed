package org.app.speed.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class LogVO extends BasePaginationVO {


    private Integer id;

    private String message;


}
