package cn.jiyun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@TableName("tb_order_num")
public class OrderNum {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String dept;
    private String doctor;
    @JsonFormat(pattern = "yyyy年MM月dd日  ")
    private Date time;
    private String time1;
    private Integer money;
    private String user;
}
