package com.mall.test;

import com.mall.common.util.FastDFSClient;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;

/**
 * 测试FastDFS文件上传
 * @author Sam
 * @date 2018/9/23
 * @time 12:52
 */
public class TestFastDfsClient {

    @Test
    public void testFastDfs() throws IOException, MyException {
        ClientGlobal.init("C:\\Users\\Sam\\IdeaProjects\\mall\\mall_manager_service\\src\\main\\resources\\properties\\client.conf");

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        String[] strings = storageClient.upload_file("C:\\Users\\Sam\\Desktop\\test.jpg","jpg",null);
        for (String str:
             strings) {
            System.out.println(str);
        }
    }

    @Test
    public void testFileUpload() throws Exception {
        // 1、把FastDFS提供的jar包添加到工程中
        // 2、初始化全局配置。加载一个配置文件。
        ClientGlobal.init("C:\\Users\\Sam\\IdeaProjects\\mall\\mall_manager_service\\src\\main\\resources\\properties\\client.conf");
        // 3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 4、创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7、直接调用StorageClient对象方法上传文件即可。
        String[] strings = storageClient.upload_file("D:\\2018427bak\\test.jpg", "jpg", null);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void testToolUoload() throws Exception {
        FastDFSClient client = new FastDFSClient("C:\\Users\\Sam\\IdeaProjects\\mall\\mall_manager_service\\src\\main\\resources\\properties\\client.conf");
        String str = client.uploadFile("D:\\2018427bak\\test.jpg", "jpg", null);
        System.out.println(str);
    }

}
