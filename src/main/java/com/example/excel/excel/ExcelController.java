package com.example.excel.excel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @date: 2019/1/8 16:37
 * @version:1.0
 **/
@RestController
@RequestMapping("excel")
public class ExcelController {

    @RequestMapping(value = "writeExcel", method = RequestMethod.GET)
    public void writeExcel(HttpServletResponse response) throws IOException {
        List<SysUser> list = getList();
        String fileName = "单个sheet的 文件";
        String sheetName = "第一个 sheet";
        //单个sheet
        ExcelUtil.writeExcel(response, list, fileName, sheetName, new SysUser());
    }

    @RequestMapping(value = "writeExcelWithSheets", method = RequestMethod.GET)
    public void writeExcelWithSheets(HttpServletResponse response) throws IOException {
        List<SysUser> list = getList();
        String fileName = "多个sheet的 文件";
        String sheetName1 = "第一个 sheet";
        String sheetName2 = "第二个 sheet";
        String sheetName3 = "第三个 sheet";

        List<String> sheetList = new ArrayList<>();
        sheetList.add(sheetName1);
        sheetList.add(sheetName2);
        sheetList.add(sheetName3);


        ExcelUtil.writeExcelWithSheets(response, list, fileName, sheetName1, new SysUser())
                .write(list, sheetName2, new SysUser())
                .write(list, sheetName3, new SysUser())
                .finish();
    }

    @RequestMapping(value = "readExcel", method = RequestMethod.POST)
    public List<SysUser> readExcel(@RequestParam("file") MultipartFile excel) {
        Object objects = ExcelUtil.readExcel(excel, new SysUser());


        return (List<SysUser>) objects;
    }


    public List<SysUser> getList() {
        List<SysUser> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setId(i);
            sysUser.setPwd("pwd" + i);
            sysUser.setUserName("userName" + i);
            list.add(sysUser);
        }
        return list;
    }

}
