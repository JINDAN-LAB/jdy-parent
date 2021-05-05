package com.edu.jdy.weixin;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Datas {
    private String value;
    private String color;
}
