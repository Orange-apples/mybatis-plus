package com.li.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "emp",resultMap = "empMap",excludeProperty = {"dept","role"})
public class Emp extends Model<Emp> implements Serializable{
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String empNo;
    private String sex;
    private String phone;
    private String state;
    private Integer deptId;
    private Integer roleId;
    private Dept dept;
    private Role role;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
