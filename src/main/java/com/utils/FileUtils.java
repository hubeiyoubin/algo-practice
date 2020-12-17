package com.utils;

import java.io.File;

/**
 * @author yb
 * @date: 2020-8-6
 */
public class FileUtils {

    public static void main(String[] args){
        String dic = "D:\\DevelopData\\project";
        File file=new File(dic);
        File [] files = file.listFiles();
        //开始重命名
        for(int i=0;i<files.length;i++){
            File toBeRenamed = files[i];
            //检查要重命名的文件是否存在
            if (!toBeRenamed.exists()) {
                System.out.println("File does not exist: "+i);
                return;
            }
            //修改文件名
            File newFile = new File(files[i].getAbsolutePath().replace("-","--"));
            if (toBeRenamed.renameTo(newFile)) {
                System.out.println("File renamed success!!.");
            } else {
                System.out.println("Error renmaing file");
            }
        }

    }
}
