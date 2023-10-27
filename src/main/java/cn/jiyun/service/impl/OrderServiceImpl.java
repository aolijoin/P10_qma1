package cn.jiyun.service.impl;

import cn.jiyun.entity.Dept;
import cn.jiyun.entity.OrderNum;
import cn.jiyun.mapper.DeptMapper;
import cn.jiyun.mapper.OrderMapper;
import cn.jiyun.result.Result;
import cn.jiyun.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private DeptMapper deptMapper;

    @Override
    @Transactional
    public Result insert(OrderNum orderNum) {
        orderNum.setTime(new Date());
        orderMapper.insert(orderNum);

        LambdaQueryWrapper<Dept> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dept::getDept, orderNum.getDept());
        Dept dept = deptMapper.selectOne(wrapper);
        dept.setNum(dept.getNum() - 1);
        deptMapper.updateById(dept);

        return Result.success(orderNum);
    }

    @Override
    public void daodaodao(HttpServletResponse res) throws IOException {
        String[] title = {"编号", "就诊科室", "就诊时间", "接诊医生", "挂号费", "就诊人"};
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        XSSFRow head = sheet.createRow(0);
        for (int i = 0; i < title.length; i++) {
            head.createCell(i).setCellValue(title[i]);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 ");
        List<OrderNum> orderNums = orderMapper.selectList(null);
        for (int i = 0; i < orderNums.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            OrderNum order = orderNums.get(i);
            row.createCell(0).setCellValue(order.getId());
            row.createCell(1).setCellValue(order.getDept());
            row.createCell(2).setCellValue(format.format(order.getTime()) + order.getTime1());
            row.createCell(3).setCellValue(order.getDoctor());
            row.createCell(4).setCellValue(order.getMoney());
            row.createCell(5).setCellValue(order.getUser());
        }

        res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("订单.xlsx", "UTF-8"));
        res.setHeader("Connection", "close");
        res.setHeader("Content-Type", "application/octet-stream");
        wb.write(res.getOutputStream());
    }
}

