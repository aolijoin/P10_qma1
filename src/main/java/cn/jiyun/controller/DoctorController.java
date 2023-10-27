package cn.jiyun.controller;

import cn.jiyun.result.PageResult;
import cn.jiyun.service.DoctorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Resource
    private DoctorService doctorService;


    @RequestMapping("getAll")
    public PageResult pageResult(Integer page, Integer size, @RequestBody Map<String, Object> serchMap) {
        return doctorService.getAll(page, size, serchMap);
    }
}
