package com.li.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "meeting",excludeProperty = "emp",resultMap = "meetingMap")
public class Meeting {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer empId;
    private String title;
    private Date startTime;
    private Date endTime;
    private String content;
    private String address;
    private Emp emp;


}
