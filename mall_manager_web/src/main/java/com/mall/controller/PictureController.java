package com.mall.controller;

import com.mall.common.pojo.PictureResult;
import com.mall.common.util.JsonUtils;
import com.mall.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Sam
 * @date 2018/9/23
 * @time 16:07
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/pic/upload")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile) throws IOException {
        String path = uploadFile.getClass().getResource("/").getPath();
        String originalFilename = uploadFile.getOriginalFilename();
        byte[] bytes = uploadFile.getBytes();
        PictureResult result = pictureService.uploadPic(path, originalFilename, bytes);
        String jsonResult = JsonUtils.objectToJson(result);
        //dubbo不能序列化,将所需要的参数进行序列化
        //PictureResult result = pictureService.uploadPic(uploadFile);
        return jsonResult;
    }
}
