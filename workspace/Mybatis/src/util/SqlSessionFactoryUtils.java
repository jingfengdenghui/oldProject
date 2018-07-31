package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {
private  static  SqlSessionFactory SqlSessionFactory=null;
	private SqlSessionFactoryUtils() {}
	public synchronized static  SqlSessionFactory getSqlSessionFactory() {
		if(SqlSessionFactory!=null)return SqlSessionFactory;
		String resource="Configuration.xml";
		InputStream in=null;
		try {
			in=Resources.getResourceAsStream(resource);
			SqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return SqlSessionFactory;	
	}
	public static SqlSession openSession() {
		if(SqlSessionFactory==null) {
			getSqlSessionFactory();
		}
		return SqlSessionFactory.openSession();
	}

}
