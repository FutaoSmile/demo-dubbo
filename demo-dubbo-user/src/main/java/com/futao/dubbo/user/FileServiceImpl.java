package com.futao.dubbo.user;

import com.futao.api.service.FileService;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author ft
 * @date 2021/1/13
 */
@Slf4j
@Service
@org.apache.dubbo.config.annotation.Service
public class FileServiceImpl implements FileService {

    @SneakyThrows
    @Override
    public void upload(File file) {
        File curFile = new File("./up/" + file.getName());
        curFile.createNewFile();

        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024 * 4];
        int i = 0;
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(curFile));
        while ((i = bufferedInputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, i);
        }
        bufferedInputStream.close();
        outputStream.close();
        log.info("文件[{}]保存成功", file.getName());
    }

    @SneakyThrows
    @Override
    public void uploadIs(InputStream is, String fileName) {
        File curFile = new File("./up/" + fileName);
        curFile.createNewFile();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(curFile));

        BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
        byte[] bytes = new byte[1024 * 4];
        int curBytes = 0;
        while ((curBytes = bufferedInputStream.read(bytes)) > 0) {
            bufferedOutputStream.write(bytes, 0, curBytes);
        }
        bufferedOutputStream.close();
        log.info("写入成功");
    }

    @Override
    public File download(String filePath) {
        log.info("开始下载文件[{}]", filePath);
        return null;
    }


}
