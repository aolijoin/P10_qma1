package cn.jiyun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@TableName("tb_doctor")
public class Doctor implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String time;
    private Integer did;
    @TableField(exist = false)
    private String dept;
    @TableField(exist = false)
    private Integer num;
}
