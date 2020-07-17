package com.example.o2o.util;

/**
 * 路径处理工具类
 */
public class PathUtil {
        // 获取系统分隔符
        private static String separator = System.getProperty("file.separator");

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
         * 返回项目图片的子路径
         * @param shopId
         * @return
         */
        public static String getShopImagePath(Integer shopId){
                String imagePath = "/upload/item/shop/" + shopId + "/";
                // 替换分隔符
                return imagePath.replace("/", separator);
        }


}
