package org.app.speed.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasePaginationVO {
    private Integer index;

    private Integer onPage;

    private Integer onePageSize;

    public Integer getIndex() {
        return (onPage - 1) * onePageSize;
    }
}
