package com.system.service.File.impl;


import com.system.service.File.FileManagerService;
import com.system.utils.fdfs.FastDfsUtils;
import com.system.utils.fdfs.UploadResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 项目名称：dogmanager-fileManager
 * 类名称：FIleManagerService
 * 类描述：
 * 创建人：YL
 * 创建时间：2018年8月30日 下午8:44:07
 * 修改人：Administrator
 * 修改时间：2018年8月30日 下午8:44:07
 * 修改备注：
 */
@Service
public class FileManagerServiceImpl implements FileManagerService {


    public List<UploadResult> upPictureBatch(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = Murequest.getFileMap();//得到文件map对象

        List<UploadResult> ets = new ArrayList<>();
        for (String key : files.keySet()) {
            MultipartFile attach = files.get(key);
            try {
                //2.上传
                ets.add(FastDfsUtils.upload(attach));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ets;
    }

}

