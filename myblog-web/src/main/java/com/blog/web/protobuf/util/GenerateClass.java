package com.blog.web.protobuf.util;

import java.io.IOException;

public class GenerateClass {

	 public static void main(String[] args) {
	        String protoFile = "UserInfo.proto";//  
	        String strCmd = "E:/protoc-3.3.0-win32/bin/protoc.exe "
	        		+ "-I=E:/git/develop/myblog-web/src/main/java/com/blog/web/protobuf/ "
	        		+ "--java_out=E:/git/develop/myblog-web/src/main/java/com/blog/web/protobuf/"
	        		+" E:/git/develop/myblog-web/src/main/java/com/blog/web/protobuf/"+protoFile;
	        System.out.println( strCmd);
	        try {
	            Runtime.getRuntime().exec(strCmd);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }//通过执行cmd命令调用protoc.exe程序  
	    }
}
