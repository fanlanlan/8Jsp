package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatiesUtil {
	private static SqlSessionFactory factory = null;
	static {
		try {
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			factory = builder.build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSession getSession(){
		SqlSession session = factory.openSession();
		return session;
	}
	public static void close(SqlSession session){
		if(session!=null)session.close();
	}
}
