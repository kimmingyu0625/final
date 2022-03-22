package net.edupoll.kr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.TimeCountVo;
import net.edupoll.kr.repository.TimeCountDao;

@Service
public class TimeService {

	@Autowired
	TimeCountDao timeCountDao;
	
	
	public List<Object[]> timeCount(){	
		
		
		List<TimeCountVo> li =  timeCountDao.timeCount();
		List<Object[]>  ret = new ArrayList<>();
		ret.add(new Object[] {"hours", "count"});
		
		for(TimeCountVo vo: li) {
			
			ret.add(new Object[] {vo.getHour(),vo.getCnt()});
		}
		
			return ret;
	}
}
