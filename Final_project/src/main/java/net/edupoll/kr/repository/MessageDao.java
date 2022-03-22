package net.edupoll.kr.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.MessageVo;

@Repository
public class MessageDao {

	

	@Autowired
	SqlSession sqlSession;
	
	
	public List<MessageVo> selectByRecipient(String id) {
		
			return sqlSession.selectList("message.selectByRecipient", id);
		
	}

	public List<MessageVo> selectByWriter(String id) {
		
		return sqlSession.selectList("message.selectByWriter", id);
		
	}
	
	public int insertSend(MessageVo vo) {
		
		
		return sqlSession.insert("message.insertSend",vo);
	}
	
	public MessageVo selectById(int no) {
		
		return sqlSession.selectOne("message.selectById",no);
	}
	
	public int sentdataUpdate(int no) {
		
		return sqlSession.update("message.sentdataUpdate",no);
	}
	
	public int checkDelete(List<String> no) {
		
		return sqlSession.delete("message.checkDelete",no);
	}
	
	public int selectCount(String id) {
		
		return sqlSession.selectOne("message.selectCount",id);
	}
}
