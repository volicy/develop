package com.blog.web.protobuf;

public class ProtoTest {

	public static void main(String[] args) {
		UserJson.UserInfo.Builder json=UserJson.UserInfo.newBuilder();
		json.setId(1);
		json.setName("2");
		
		UserJson.UserInfo view=json.build();
		System.out.println("view:"+view.toString());
		
	}
}
