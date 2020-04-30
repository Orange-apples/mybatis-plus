package com.li.demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends Model<Role> implements Serializable{
    private Integer id;
    private String name;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
