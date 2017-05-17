package com.boot.test.config;

import java.io.File;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.hengxin.util.Constants;
import com.hengxin.util.DesUtils;
import com.hengxin.util.MyFileUtils;


public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	// private static final String thekey = MyFileUtils.getProperty( "jdbc_key" );
	
	@Autowired
	private Config config;

	protected void processProperties( ConfigurableListableBeanFactory beanFactory, Properties props ) throws BeansException {
		try {

			String thekey =config.getJdbc_key();
			for ( Object obj : props.keySet( ) ) {
				String key = ( String ) obj;
				if ( !key.startsWith( Constants.JDBC_PROP_KEY ) )
					continue;
				String password = props.getProperty( key );
				if ( password != null ) {
					props.setProperty( key, DesUtils.decrypt( password, thekey.getBytes( "UTF-8" ) ) );
				}

			}

			super.processProperties( beanFactory, props );
		} catch ( Exception e ) {
			e.printStackTrace( );
			throw new BeanInitializationException( e.getMessage( ) );
		}
	}
}
