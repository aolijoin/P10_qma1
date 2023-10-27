package cn.jiyun.service;

import cn.jiyun.result.PageResult;

import java.util.Map;

public interface DoctorService {
    PageResult getAll(Integer page, Integer size, Map<String, Object> serchMap);
}
