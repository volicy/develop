package com.blog.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class SqlParameterFilter extends HttpServletRequestWrapper {

	public SqlParameterFilter(HttpServletRequest request) {
		super(request);
	}

	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter); 
		if (values == null) 
			return null; 
		int count = values.length; 
		String[] sqlValues = new String[count]; 
		for (int i = 0; i < count; i++) { 
			//如果参数不含SQL关键字则返回，如果含有关键字则置为空
			if(!sql_inj(values[i]))
				sqlValues[i] = values[i];
			else
				sqlValues[i] = "";
		} 
		return sqlValues; 
	}
	public String getParameter(String parameter) {
		// log.info("=== getParameter");
		String value = super.getParameter(parameter);
		if(!sql_inj(value))
			return value;
		else
			return "";
	}
	
	public boolean sql_inj(String str){
		if(str == null || str.isEmpty())
			return false;
		
		String inj_str = "'|like|in|and|exec|insert|select|delete|update|count|from|*|%|chr|reg|mid|master|truncate|char|declare|; |or|-|+|-p|-t|,"; 
		String[] inj_stra=inj_str.split("\\|");  
		for (int i=0 ; i < inj_stra.length ; i++ ){
			if (str.toLowerCase().indexOf(" "+inj_stra[i]+" ")>=0){  
				return true;  
			}  
		}  
		return false;  
	}  
	
}
