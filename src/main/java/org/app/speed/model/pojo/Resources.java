package org.app.speed.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LianQianChao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resources implements Serializable {

    private Integer id;

    private String name;

    private Integer menuLevel;

    private String menuUrl;

    private Integer sort;

    private Integer enable;

    private Date createTime;

    private Date updateTime;

    private String changer;

}
