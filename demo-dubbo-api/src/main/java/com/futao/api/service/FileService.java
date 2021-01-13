package com.futao.api.service;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作-测试在Dubbo中传输文件
 *
 * @author ft
 * @date 2021/1/13
 */
public interface FileService {
    /**
     * 上传文件
     *
     * @param file 文件
     */
    void upload(File file);

    /**
     * 通过输出流上传
     *
     * @param is
     * @param fileName
     */
    void uploadIs(InputStream is, String fileName);

    /**
     * 下载文件
     *
     * @param filePath 文件路径
     * @return 文件
     */
    File download(String filePath);
}
