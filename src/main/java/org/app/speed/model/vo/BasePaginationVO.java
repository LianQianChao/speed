package org.app.speed.model.vo;

import lombok.*;

@Data
@NoArgsConstructor
public class BasePaginationVO {
    private Integer index;

    private Integer onPage;

    private Integer onePageSize;

    public Integer getIndex() {
        return (onPage - 1) * onePageSize;
    }
}
