package cn.jiyun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@TableName("tb_name")
public class Dept implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String dept;
    private Integer num;
}
