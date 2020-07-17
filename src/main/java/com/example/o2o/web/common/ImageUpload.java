package com.example.o2o.web.common;

import com.example.o2o.enums.ResultEnum;
import com.example.o2o.exception.UploadException;
import com.example.o2o.util.*;
import com.example.o2o.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("upload")

/**
 * 文件上传类
 */
public class ImageUpload {
    /**
     * 单文件上传
     * @param file
     * @return
     */
    @PostMapping("/img")
    public ResultVO uploadFile(@RequestParam(value = "file") MultipartFile file){
        if(file.isEmpty()){
            return ResultVOUtil.error(ResultEnum.IMG_ISNULL.getMsg(), ResultEnum.IMG_ISNULL.getCode());
        }
        String shopImagePath = PathUtil1.getShopImagePath();
        String s = ImageUtil2.generateThumbnail(file, shopImagePath);
        return ResultVOUtil.success(s);
    }

    /**
     * 多文件上传
     * @param files
     * @return
     */
    @PostMapping("/imgs")
    public ResultVO uploadFiles(@RequestParam(value = "files") MultipartFile[] files){
        if(files.length < 1 ){
            return ResultVOUtil.error(ResultEnum.IMG_ISNULL.getMsg(), ResultEnum.IMG_ISNULL.getCode());
        }

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < files.length ; i++) {
            String shopImagePath = PathUtil1.getShopImagePath();
            String s = ImageUtil2.generateThumbnail(files[i], shopImagePath);
            arrayList.add(s);
        }
        return ResultVOUtil.success(arrayList);
    }
}
