package cn.jiyun.mapper;

import cn.jiyun.entity.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DoctorMapper extends BaseMapper<Doctor> {
    @Select("<script> select d.*,e.num num,e.dept dept\n" +
            "from qma.tb_doctor d\n" +
            "         left join qma.tb_dept e on d.did = e.id\n" +
            "                                        where 1=1 \n" +
            "<if test='dept!=null and dept!=\"\"'> and e.dept=#{dept} </if>\n" +
            "<if test='name!=null and name!=\"\"'> and d.name like concat('%',#{name},'%') </if> </script>")
    List<Doctor> selectLike(Map<String, Object> serchMap);
}
