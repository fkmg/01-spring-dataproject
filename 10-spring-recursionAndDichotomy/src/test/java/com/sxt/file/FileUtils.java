package com.sxt.file;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;

public class FileUtils {

    @Test
    public void analysisFileErrors(){
        File fileRoote = new File("G:\\html\\files\\zookeeper-jute");
        File target = new File("G:\\html\\files\\target");
        File fileNew = null;
        //1、读取根目录文件
        fileNew = new File(target.getAbsolutePath() + "\\" + fileRoote.getName());
        if (!fileRoote.isFile()){
            //2、在目标文件中创建该目录
            fileNew.mkdir();
        }else {
            //3、判断文件是否以.java结尾
            try {
                fileNew.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (StringUtils.endsWith(fileRoote.getName(),".java")){

            }
        }
    }

    private void writeFileToAnotherDirectory(File file,File targetDirectory) throws IOException {
        BufferedReader br = null;
        InputStream fin = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(fin));

        BufferedWriter bw = null;
        OutputStream out = new FileOutputStream(targetDirectory);
        bw = new BufferedWriter(new OutputStreamWriter(out));

        String strTemp = null;

        strTemp=br.readLine();
        while (StringUtils.isNotBlank(strTemp)){
            //1、判断文字是否包含错误内容
            if (StringUtils.contains(strTemp,""));
        }
    }
}
