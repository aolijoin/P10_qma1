package cn.jiyun.controller;

import cn.jiyun.entity.OrderNum;
import cn.jiyun.result.Result;
import cn.jiyun.service.OrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("insert")
    public Result insertOrder(@RequestBody OrderNum orderNum) {
        return orderService.insert(orderNum);
    }

    @RequestMapping("daodaodao")
    public void daodaodao(HttpServletResponse res) throws IOException {
        orderService.daodaodao(res);
    }
}
