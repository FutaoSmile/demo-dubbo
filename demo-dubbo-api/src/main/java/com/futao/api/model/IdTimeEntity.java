package com.futao.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ft
 * @date 2021/1/8
 */
@Getter
@Setter
public class IdTimeEntity implements Serializable {
    private Long id;
    private Long createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createDateTime;
    private Long updateBy;
    private LocalDateTime updateDateTime;
}
