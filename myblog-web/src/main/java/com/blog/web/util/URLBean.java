package com.blog.web.util;

import java.util.ArrayList;
import java.util.List;

public class URLBean {
	
	private int visitLimit = 600;//每3分钟访问次数上限
	
	private String unRestrictIp ;//不限制访问的ip地址前缀
	
	private List<String> countFilterURL = new ArrayList<String>();//需要限制访问的接口

	 public List<String> getCountFilterURL() {
	  return countFilterURL;
	 }

	 public void setCountFilterURL(List<String> countFilterURL) {
	  this.countFilterURL = countFilterURL;
	 }

	 public int getVisitLimit() {
	  return visitLimit;
	 }

	 public void setVisitLimit(int visitLimit) {
	  this.visitLimit = visitLimit;
	 }

	 public String getUnRestrictIp() {
	  return unRestrictIp;
	 }

	 public void setUnRestrictIp(String unRestrictIp) {
	  this.unRestrictIp = unRestrictIp;
	 }
	 
	 
}
