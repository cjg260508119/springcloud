package com.chen.sphere.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author 26050
 * @Date 2023/5/23 16:31
 * @Version 1.0
 */
@Data
@TableName(value = "orders")
public class OrderDo {

    private Long id;

    private Integer userId;
}
