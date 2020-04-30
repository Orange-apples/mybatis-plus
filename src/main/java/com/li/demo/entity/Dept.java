package com.li.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.plugin2.message.Serializer;

import java.io.Serializable;
import java.net.IDN;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept extends Model<Dept> implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String content;
    private String dNo;
}
