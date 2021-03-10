package org.app.speed.model.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Log implements Serializable {

    private Integer id;

    private String message;
}
