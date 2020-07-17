package com.example.o2o.util;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Slf4j
public class ImageUtil1 {

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    // 时间
    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    // 随机数
    private static final Random r = new Random();


    /**
     * 把CommonsMultipart 转换为java.io.File
     * @param commonsMultipartFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile commonsMultipartFile){
        File newFile = new File(commonsMultipartFile.getOriginalFilename());
        try {
            commonsMultipartFile.transferTo(newFile);
        } catch (IOException e) {
            log.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }


    /**
     * 处理缩略图，并返回新图片的相对子路径
     * @param commonsMultipartFile
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(File commonsMultipartFile, String targetAddr){
        // 为防止重复文件名，自定义随机生成文件名
        String realFileName = getRandomFileName();
        // 获取后缀名
        String extension = getFileExtension(commonsMultipartFile);
        // 创建路径
        mkdirDirPath(targetAddr);
        // 全路径
        String relativeAddr = targetAddr + realFileName + extension;
        log.info("relativeAddr:{}", relativeAddr);
        // 生成文件
        File file = new File(PathUtil.getImgBasePath() + relativeAddr);
        log.info("realAddr:{}", PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(commonsMultipartFile).size(200, 200 )
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/water.png")), 0.25f)
                    .outputQuality(0.5)
                    .toFile(file);
        } catch (IOException e) {
            log.error(e.toString());
            e.printStackTrace();
        }
        //为什么返回相对地址而不是绝对地址：希望项目迁移到别的地址后，也能访问数据库里的图片地址，不需要去改；
        return relativeAddr;

    }



    /**
     * 生成随机文件名: 当前时间时分秒 + 五位随机数
     * @return
     */
    private static String getRandomFileName() {
        // 获取5位随机数
        int rannum = r.nextInt(89999) + 10000;
        // 获取当前的时间
        String nowTimeStr = simpleDateFormat.format(new Date());
        return  nowTimeStr + rannum;
    }


    /**
     * 获取输入文件流的扩展名
     * @param commonsMultipartFile
     * @return
     */
    private static String getFileExtension(File commonsMultipartFile){
        String originalFileName = commonsMultipartFile.getName();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 创建目标路径所涉及到的目录,即/home/work/img/xxx.jpg, 那么 home work img 这三个目录都要自动创建
     * @param targetAddr
     */
    private static void mkdirDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("/Users/beast/Downloads/WX20200630-200811@2x.png"))
                .size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/water.png")), 0.25f)
                .outputQuality(0.5)
                .toFile(new File("image-with-watermark.jpg"));
    }
}
