package cn.jiyun.service.impl;

import cn.jiyun.entity.Doctor;
import cn.jiyun.mapper.DoctorMapper;
import cn.jiyun.result.PageResult;
import cn.jiyun.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public PageResult getAll(Integer page, Integer size, Map<String, Object> serchMap) {
        PageHelper.startPage(page, size);
        System.out.println(serchMap);
        List<Doctor> doctors = doctorMapper.selectLike(serchMap);
        PageInfo pageInfo = new PageInfo(doctors);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
