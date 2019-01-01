package com.iease.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.lang.StringUtils;

/**
 * 文件操作工具�?
 * @author 807547
 *
 */
public class FileUtil {
	/**
	 * 保存文件到指定目�?
	 * @param desDir 要保存的目录
	 * @param fileName 文件�?
	 * @return 返回文件完整路径
	 */
	public static String saveFile(File file, String desDir,String fileName) throws Exception{
		if(null == file || 0 == file.length()){
			throw new Exception("文件为空�?");
		}
		if(StringUtils.isEmpty(desDir)){
			throw new Exception("目录为空�?");
		}
		if(StringUtils.isEmpty(fileName)){
			throw new Exception("文件名为空！");
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File dirs = new File(desDir);
		if(!dirs.exists()){
			dirs.mkdirs();
		}
		String filePath = desDir + File.separator + fileName;
		File desFile = new File(filePath);
		if(desFile.exists()){
			throw new Exception("该文件已经存在！");
		}
		desFile.createNewFile();
		fis = new FileInputStream(file);
		fos = new FileOutputStream(desFile);
		int len = -1;
		byte[] data = new byte[1024];
		while((len = fis.read(data)) != -1){
			fos.write(data,0,len);
		}
		fos.flush();
		fis.close();
		fos.close();
		return filePath;
	}
	
	/** 
    * @Description:  删除目录下的文件及文件夹
    * @author  丁金�?
    * @date    2017�?6�?28�? 上午8:53:44 
    * @param   dir
    * @return  boolean
    */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删�?
        return dir.delete();
    }
}
