package com.mall.service;

import com.mall.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传
 * @author Sam
 * @date 2018/9/23
 * @time 15:40
 */
public interface PictureService {
    /**
     * 上传文件
     * @param picFile
     * @return
     */
    PictureResult uploadPic(MultipartFile picFile);
    PictureResult uploadPic(String path,String fileName,byte[] bytes);
}
