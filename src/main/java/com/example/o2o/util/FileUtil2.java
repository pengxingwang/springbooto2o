package com.example.o2o.util;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Slf4j
public class FileUtil2 {

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    // 时间
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    // 随机数
    private static final Random r = new Random();

    /**
     * 处理缩略图，并返回新图片的相对子路径
     * @param multipartFile
     * @param targetAddr
     * @return
     */
    public static String generateFile(MultipartFile multipartFile, String targetAddr){
        // 为防止重复文件名，自定义随机生成文件名
        String realFileName = getRandomFileName();
        // 获取后缀名
        String extension = getFileExtension(multipartFile);
        // 创建路径
        mkdirDirPath(targetAddr);
        // 全路径
        String relativeAddr = targetAddr + realFileName + extension;
        log.info("relativeAddr:{}", relativeAddr);
        // 生成文件
        File file = new File(PathUtil.getImgBasePath() + relativeAddr);
        log.info("realAddr:{}", PathUtil.getImgBasePath() + relativeAddr);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            log.error(e.toString());
            e.printStackTrace();
        }
        //为什么返回相对地址而不是绝对地址：希望项目迁移到别的地址后，也能访问数据库里的图片地址，不需要去改；
        return relativeAddr;

    }


    /**
     * 删除目录或文件
     * @param path
     */
    public static void deleteFileOrPath(String path){
        File file = new File(PathUtil.getImgBasePath() + path);
        if(file.exists()){
            if(file.isDirectory()){
                File files[] = file.listFiles();
                for (int i = 0; i <files.length ; i++) {
                    files[i].delete();
                }
            }
            file.delete();
        }
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
     * @param multipartFile
     * @return
     */
    private static String getFileExtension(MultipartFile multipartFile ){
        String originalFileName = multipartFile.getOriginalFilename();
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
