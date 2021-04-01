package org.app.speed.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogVO extends BasePaginationVO {


    private Integer id;

    private String message;


}
