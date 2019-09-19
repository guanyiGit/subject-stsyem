package com.system.controller.file;

import com.system.service.File.FileManagerService;
import com.system.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 项目名称：dogmanager-web
 * 类名称：FileManagerController
 * 类描述：
 * 创建人：YL
 * 创建时间：2018年8月30日 下午7:59:43
 * 修改人：Administrator
 * 修改时间：2018年8月30日 下午7:59:43
 * 修改备注：
 */
@Controller
@RequestMapping("/file")
public class FileManagerController {


    @Autowired
    private FileManagerService fileManagerService;

    /**
     * 支持批量上传
     * 参数一： HttpServletRequest
     * 参数二：业务对象id
     * 参数三:图片类型
     */
    @RequestMapping("/upload/batch")
    @ResponseBody
    public R uploadFileBatch(HttpServletRequest request) throws Exception {
        try {
            return R.ok(fileManagerService.upPictureBatch(request));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("上传失败");
        }
    }
}
