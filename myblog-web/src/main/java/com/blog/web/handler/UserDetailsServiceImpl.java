package com.blog.web.handler;

import java.io.BufferedInputStream;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.userdetails.AbstractCasAssertionUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*import org.apache.commons.lang3.StringUtils;
import org.zywx.appdo.entity.account.AdminUserInfo;
import org.zywx.appdo.entity.privilege.NodulePrivilege;
import org.zywx.appdo.mam.dao.privilege.AdminUserGroupPrivilegeManagerDao;
import org.zywx.appdo.mam.service.app.AppService;
import org.zywx.appdo.mam.service.privilege.AdminUserGroupPrivilegeService;
import org.zywx.appdo.mam.service.role.AdminUserGroupWithUserService;
import org.apache.struts2.ServletActionContext;
import org.zywx.appdo.mdm.entity.application.MdmAplctiongrp;*/



/**
 * 此类描述的是：用户登录spring-security的接口
 */

public class UserDetailsServiceImpl extends AbstractCasAssertionUserDetailsService {

    private Log Logger = LogFactory.getLog(getClass());

    /*@Autowired
    private UserService userService;
    @Autowired
    private AdminUserGroupWithUserService adminUserGroupWithUserService;
    @Autowired
    private AdminUserGroupPrivilegeManagerDao adminUserGroupPrivilegeManagerDao;
    @Autowired
    private AdminUserGroupPrivilegeService adminUserGroupPrivilegeService;
    @Autowired
    private LogoInfoService logoInfoService;
    

    @Autowired
    private AppService appService;*/
    /**
	 * 根据cas返回的nickname查找相应的user
	 * 同时需要记录email地址
	 * 
	 */
	@Override
	protected UserDetails loadUserDetails(final Assertion assertion) {
        Logger.info("in UserDetailsServiceImpl");

        AttributePrincipal principal = assertion.getPrincipal();
        
        
        String userName = principal.getName();
        /*Map<String, String> ssoMap = principal.getAttributes();
        for(Map.Entry<String, String> entry: ssoMap.entrySet()){
        	System.out.println(entry.getKey()+":"+entry.getValue());
        }
        */
        /*Logger.info("login name: "+userName);
        AdminUserInfo user = userService.findUserByName(userName);
        if (user == null) {
            Logger.error("not exist user visit with name: " + userName);
            throw new UsernameNotFoundException("user insert error with name: " + userName);
        }
        
        Timestamp currentTime = new Timestamp(new Date().getTime());
        user.setLastLoginAt(currentTime);
        userService.save(user);*/
        
        Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities();

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
      
        
        UserDetails userdetails = new org.springframework.security.core.userdetails.User(
        		userName, "", enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, grantedAuths);
        


        return userdetails; 
	}

    /**  
     * 返回授权列表
     *
     * @param user
     * @return 
     */
    private Set<GrantedAuthority> obtainGrantedAuthorities() {
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        
        authSet.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authSet;
    }
       /* if(user.getLoginName().equals("admin")){
        	List<NodulePrivilege> nos=adminUserGroupPrivilegeService.findByAllNodulePrivilege();
        	if(nos!=null && nos.size() != 0){
				for(NodulePrivilege n : nos){
					if(StringUtils.isNotBlank(n.getUrl())){
						authSet.add(new SimpleGrantedAuthority(n.getUrl()));
					}
				}
			}
        }
        else{
        	List<Object> objects=adminUserGroupPrivilegeManagerDao.getNodulePrivileges(user.getId());
        	String id="";
        	if(objects != null && objects.size() > 0){
        		if(objects.get(0) instanceof Clob){
        			id=changeClobToString((Clob) objects.get(0));
        		}else{
        			id=objects.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
        		}
        	}
        		if (StringUtils.isNotBlank(id)&&id.startsWith(",")) {
    				id=id.substring(1);
    			}
        	if(StringUtils.isNotBlank(id)){
        		List<NodulePrivilege> nos=adminUserGroupPrivilegeService.findByNodulePrivilege(id);
        		if(nos!=null && nos.size() >0){
        			for(NodulePrivilege n : nos){
    					if(StringUtils.isNotBlank(n.getUrl())){
    						System.out.println(n.getUrl());
    						authSet.add(new SimpleGrantedAuthority(n.getUrl()));
    					}
    				}
        		}
        	}
    		
        }
        List<String> list=new ArrayList<String>();
		list.add("Ĭ����");
		list.add("��������");
		list.add("��������");
		for(String s:list){
			MdmAplctiongrp mdm=appService.findByLoginNameAndName(user.getLoginName(),s);
			if(mdm==null){
				mdm=new MdmAplctiongrp();
				mdm.setCreateUser(user.getLoginName());
				mdm.setName(s);
				mdm.setIsDelete(false);
				mdm.setIsSwitch(true);
				mdm.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				appService.saveMdmAplctiongrp(mdm);
			}
		}
    	authSet.add(new SimpleGrantedAuthority("APP_USER"));
        return authSet;
    }*/
    
    /**
     * oracle中的clob字段类型需要转化
     * @param clob
     * @return
     */
    public  String changeClobToString(Clob clob) {
    	try{
    		BufferedInputStream bi = new BufferedInputStream(clob.getAsciiStream());
        	int len = (int) clob.length();
        	byte[] by = new byte[len];
        	int i;
        	while (-1 != (i = bi.read(by, 0, by.length))) {
        		bi.read(by, 0, i);
        	}
        	String clobValue = new String(by);
        	bi.close();
    	
        	return clobValue;
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
   
}
