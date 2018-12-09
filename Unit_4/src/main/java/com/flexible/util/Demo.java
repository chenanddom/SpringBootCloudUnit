package com.flexible.util;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        String protoFile = "person-entity.proto";//
        String strCmd = "D:\\develop_software\\probuf\\protobuf-2.5.0\\src\\protoc.exe -I=../proto --java_out=/src/main/java ../proto/"+ protoFile;
        try {
            Runtime.getRuntime().exec(strCmd);
        } catch (IOException e) {
            e.printStackTrace();
        }//通过执行cmd命令调用protoc.exe程序
    }
}
