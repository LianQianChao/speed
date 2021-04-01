package org.app.speed.model.vo;

import lombok.*;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class LogVO {

    private Integer index;

    private Integer onPage;

    private Integer onePageSize;

    private Integer id;

    private String message;

    public Integer getIndex(){
        return  (onPage - 1) * onePageSize;
    }
}
