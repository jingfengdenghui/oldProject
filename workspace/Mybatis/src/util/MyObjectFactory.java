package util;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;




public class MyObjectFactory extends DefaultObjectFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   Logger log=Logger.getLogger(MyObjectFactory.class);
	  @Override
	  public <T> T create(Class<T> type) {
		  T result=super.create(type);
		    log.info("创建对象："+result);
		    return result;
	  }

	  @SuppressWarnings("unchecked")
	  @Override
	  public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
	    T result=super.create(type,constructorArgTypes,constructorArgs);
	    log.info("创建对象："+result);
	    return result;
	  }

	  @Override
	  public void setProperties(Properties properties) {
	    super.setProperties(properties);
	    log.info("初始化参数："+properties);
	  }

	  @Override
	  public <T> boolean isCollection(Class<T> type) {
		    return super.isCollection(type);
	  }
	
	
	

}
