package com.example.excel.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: TODO
 * @date: 2019/1/8 16:42
 * @version:1.0
 **/
@Data
public class SysUser extends BaseRowModel  implements Serializable {
    @ExcelProperty(value = "ID", index = 0)
    private Integer id;
    @ExcelProperty(value = "姓名", index = 1)
    private String userName;
    @ExcelProperty(value = "密码", index = 2)
    private String pwd;

}
