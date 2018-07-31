package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import util.User;

public interface UserMapper {

	User find(String name);
	List<User> getAll(RowBounds rowBounds);
	List<User> getAll();
	long delete(User user);
	/*ʹ��ע��*/
	long insert(@Param("name") String name,@Param("password") String password);
	/*ʹ��Map*/
	long update(Map<String,String> userMap);
	/*  ƥ���ѯ */
	List<User> findByName(String name);
	long insertTest(@Param("id") long id,@Param("name") String name,@Param("age") long age);
	/**/
	Integer updateTest(@Param("id") long id,@Param("name") String name,@Param("age") long age);
	List<User> findByNameList(@Param("nameList") List<String> nameList);
}
