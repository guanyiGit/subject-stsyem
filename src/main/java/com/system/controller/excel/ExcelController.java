package com.system.controller.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.system.pojo.excel.ExcelEasySubject;
import com.system.pojo.excel.ExcelSubjectPojo;
import com.system.service.excel.ExcelService;
import com.system.utils.R;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pengyu
 * @Date 2019/7/23
 * @Description
 */
@RestController
@RequestMapping("/biz/excel")
public class ExcelController {

    private Logger logger  = LoggerFactory.getLogger(getClass());

    @Autowired
    private ExcelService excelService;

    /**
     * 导入题库excel
     * @param file
     * @param userId
     * @return
     */
    @PostMapping("/importSubject")
    public R importSubject(@RequestParam("file") MultipartFile file, @RequestParam("userId") Integer userId){
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(2);
        importParams.setTitleRows(1);
        try {
        List<ExcelSubjectPojo> excelSubjectPojos = ExcelImportUtil
                .importExcel(file.getInputStream(), ExcelSubjectPojo.class, importParams);
            excelService.excelImportSunject(excelSubjectPojos,userId);
            return R.ok();
        } catch (Exception e){
            return R.error(400,"导入失败，请检查excel格式是否正确");
        }
    }


    @RequestMapping("/hello")
    public String hello() throws Exception{
        List<ExcelEasySubject> list = new ArrayList<>();
        ExcelEasySubject easySubject ;
        for (int i = 0;i<5;i++){
            easySubject = new ExcelEasySubject();
            easySubject.setSubjectId(i+1+"");
            easySubject.setSunjectType(1+"");
            easySubject.setSubjectMode(1+"");
            easySubject.setSubjectContent("下列哪一个选项按照顺序包括了OSI模型的七个层次：（ ）");
            easySubject.setOptions("理层 数据链路层 传输层 网络层 会话层 表示层 应用层");
            easySubject.setSubjectDifficulty(1+"");
            list.add(easySubject);
        }

        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("题库");
        // 生成workbook 并导出
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ExcelEasySubject.class, list);
        File savefile = new File("C:/Users/Administrator/Desktop/");
        if (!savefile.exists()) {
            boolean result = savefile.mkdirs();
            System.out.println("目录不存在，创建" + result);
        }
        FileOutputStream fos = new FileOutputStream("C:/Users/Administrator/Desktop/subject.xls");
        workbook.write(fos);
        fos.close();
        return "success";
    }
}
