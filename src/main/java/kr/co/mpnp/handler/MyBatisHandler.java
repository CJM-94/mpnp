package kr.co.mpnp.handler;

import java.io.IOException;
import java.io.Reader;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis Handler�� ��ȯ�ϴ� ��
 * @author user
 */
public class MyBatisHandler {

	private static MyBatisHandler mbh;
	private static SqlSessionFactory ssf;
	private MyBatisHandler() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		// �� DAO�� ������ �ϳ��� �־�����ϴµ� ���⿡ ������ 
		// handler�� ������ؼ��� ��� �긦 ��ġ�Ƿ� ���ٿ��� ����ɶ����� �������ϱ����� ���⿡ ����
	}
	
	/**
	 * factory-method = "getInstance"
	 * @return
	 */
	public static MyBatisHandler getInstance() {
		if(mbh==null) {
			mbh = new MyBatisHandler();
		}
		return mbh;
	}
	
	private static SqlSessionFactory getSessionFactory()throws IOException {
		
		if(ssf==null) {
			// 1. �������� ���� 
			//String configPath = "users/user/git/project3/src/main/java/kr/co/mpnp/admin/dao/config/mybatis-config.xml";
			//String configPath = "kr.co.mpnp.admin.dao.config.mybatis-config";
			String configPath = "kr/co/mpnp/config/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(configPath);
			
			// 2. MyBatis Framework ����
			ssf = new SqlSessionFactoryBuilder().build(reader);
			
			// 3. ��Ʈ�� �ݱ� ��Ʈ������������ �����ӿ�ũ�� �������
			if(reader!=null) {
				reader.close();
			}
			
		}
		System.out.println("MyBatisHandler ssf : " + ssf);
		return ssf;
	}
	
	/**
	 * MyBatis Handler ��ȯ
	 * @return
	 */
	public SqlSession getHandler() {
		SqlSession session = null;
		
		try {
			System.out.println("MyBatisHandler session : "+session);
			session = getSessionFactory().openSession();
		} catch (IOException e) {
			System.out.println("��������");
			e.printStackTrace();
		}
		
		System.out.println("MyBatisHandler session : "+session);
		
		return session;
	}
	
	public void closeHandler(SqlSession session) {
		session.close();
	}
	
}