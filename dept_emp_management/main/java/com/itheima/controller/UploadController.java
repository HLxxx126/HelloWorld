package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author HLxxx
 * @version 1.0
 */

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
        log.info("ファイルのアップロード:{},{},{}",username,age,image);
        //元のファイル名を取得します。
        String originalFilename = image.getOriginalFilename();
        //唯一なファイル名を構築する-uuid
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新しいファイル名:{}",newFileName);

        //ファイルをサーバーのディスクディレクトリに保存しますファイルをサーバーのディスクディレクトリに保存します
        image.transferTo(new File("/Users/dreammtank125/IdeaProjects/management_project/"+ newFileName));

        return Result.success();
    }
}
