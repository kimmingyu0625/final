package net.edupoll.kr.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.AccountVo;

@Repository
public class AccountDao {

	@Autowired
	SqlSession sqlSession;
	
	
	
	
		public String selectOne(String id) {
				
			
			return sqlSession.selectOne("signup.selectOne",id);	
				
			
		}
	
		public AccountVo selectAll(String id) {
			
			return sqlSession.selectOne("signup.selectAll",id);
			
		}
		
		
		public int updateEmail(AccountVo vo) {
			
			return sqlSession.update("signup.updateOne",vo);
		}
	
		public String selectEmail(String id) {
			
			return sqlSession.selectOne("signup.selectemail",id);
			
		}
	
		public int updateauth(String id) {
			return sqlSession.update("signup.updateauth",id);
			
		}
		
		
		public int insertOne() {
			
			return sqlSession.insert("signup.insertImage");
			
		}

	
}
