package net.edupoll.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.MessageVo;
import net.edupoll.kr.repository.MessageDao;

@Service
public class MessageService {

	@Autowired
	MessageDao messageDao;
	
	
	public List<MessageVo> selectByRecipient(String id) {
		
		return messageDao.selectByRecipient(id);
		
	}
	
	public List<MessageVo> selectByWriter(String id) {
		
		return messageDao.selectByRecipient(id);
		
	}
	public boolean insertSend(MessageVo vo) {
		
		
		
		int r = messageDao.insertSend(vo);
		
		return r==1 ? true : false; 
	}
	
	public MessageVo selectById(int no) {
		
	 return messageDao.selectById(no);
		
	}
	
	public int sentdataUpdate(int no) {
		
			
		
		return messageDao.sentdataUpdate(no);
		
	}
	
	public int checkDelete(List<String> no) {
		
		
		return messageDao.checkDelete(no);
	}
	
	public int selectCount(String id) {
		
		return messageDao.selectCount(id);
	}
	
	
}
