package util;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mapper.UserMapper;

public class Test {

	public static void main(String[] args) {
		SqlSession session = null;
		try {
			session = SqlSessionFactoryUtils.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
//			User user = mapper.find("1");
//			System.out.println(user);
//			user = new User();
//			user.setName("2");
//			user.setPassword("2");
//			 session.insert("util.UserMapper.insert",user);
//			 mapper.insert(user);
//			user.setPassword("3");
//			 Map<String,String> userMap = new HashMap<String,String>();
//			 userMap .put("name", "2");
//			 userMap .put("password", "2");
//			 mapper.update(userMap);
//			//第一个为偏移量 第几个开始读取 0表示从第一个   第二个为读取数量
//			RowBounds rowBounds = new RowBounds(0,4);
//			List<User> list = mapper.getAll();
//			System.out.println(list);
//			 mapper.insert("3", "3");
//			int a = mapper.updateTest(1,"1", 2);
//			System.out.println(a);
//			mapper.updateTest(1, null, 10);
			List<String> nameList =  new ArrayList<String>();
			nameList.add("1");
			nameList.add("11");
			nameList.add("12");
			List<User> list = mapper.findByNameList(nameList);
			System.out.println(list);
			
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}

}
