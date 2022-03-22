package net.edupoll.kr.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.AccountVo;

@Repository
public class SignUpDao {

	
	@Autowired
	SqlSession sqlSession;
	
	
	public int insertAll(AccountVo vo) {
		
		
		
		return sqlSession.insert("signup.insertAll",vo);
		
		
	}
	
}
