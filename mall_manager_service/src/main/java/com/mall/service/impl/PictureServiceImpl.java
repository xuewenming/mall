package com.mall.service.impl;

import com.mall.common.pojo.PictureResult;
import com.mall.common.util.FastDFSClient;
import com.mall.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Sam
 * @date 2018/9/23
 * @time 15:53
 */

@Service
public class PictureServiceImpl implements PictureService {


    @Override
    public PictureResult uploadPic(MultipartFile picFile) {

        try {
            if (picFile.isEmpty()) {
                PictureResult result = new PictureResult();
                result.setError(1);
                result.setMessage("图片为空");
                return result;
            }
            String originalFilename = picFile.getOriginalFilename();
            String suffixPic = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            FastDFSClient client = new FastDFSClient("properties/client.conf");
            String url = client.uploadFile(picFile.getBytes(), suffixPic, null);
            System.out.println("----------------------" + url);
            PictureResult result = new PictureResult();
            result.setError(0);
            result.setUrl(url);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            PictureResult result = new PictureResult();
            result.setError(1);
            result.setMessage("图片为空");
            return result;
        }
    }


    @Value("${IMAGE_SERVER_BASE_URL}")
    private String IMAGE_SERVER_BASE_URL;
    @Override
    public PictureResult uploadPic(String path, String fileName, byte[] bytes) {
        try {
            if (path.isEmpty()) {
                PictureResult result = new PictureResult();
                result.setError(1);
                result.setMessage("图片为空");
                return result;
            }
            String suffixPic = fileName.substring(fileName.lastIndexOf(".") + 1);
            FastDFSClient client = new FastDFSClient("classpath:properties/client.conf");
            String url = client.uploadFile(bytes, suffixPic, null);
            url = IMAGE_SERVER_BASE_URL + url;
            PictureResult result = new PictureResult();
            result.setError(0);
            result.setUrl(url);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            PictureResult result = new PictureResult();
            result.setError(1);
            result.setMessage("图片为空");
            return result;
        }



    }

    private PictureResult PictureResultCode(Integer error,String message,String url) {
        PictureResult result = new PictureResult();
        result.setError(error);
        result.setMessage(message);
        result.setUrl(url);
        return result;
    }
}
