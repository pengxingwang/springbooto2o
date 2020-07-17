package com.example.o2o.util;


import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 路径处理工具类
 */
public class PathUtil1 {
        // 获取系统分隔符
        private static String separator = System.getProperty("file.separator");

        private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        /**
         * 根路径，系统图片存放的路径
         * @return
         */
        public static String getImgBasePath(){
                // 获取系统
                String os = System.getProperty("os.name");
                String basePath = "";
                if(os.toLowerCase().startsWith("win")){
                        basePath = "D:/projectdev/image/";
                }else {
                        basePath = "/Users/beast/Downloads/image";
                }

                // 替换分隔符
                basePath = basePath.replace("/", separator);
                return basePath;
        }


        /**
         * 把日期作为文件夹保存文件
         * @return
         */
        public static String getShopImagePath(){

                String imagePath = "/upload/item/shop/" + simpleDateFormat.format(new Date()) + "/";
                // 替换分隔符
                return imagePath.replace("/", separator);
        }


}
