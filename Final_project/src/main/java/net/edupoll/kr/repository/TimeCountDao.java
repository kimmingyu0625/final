package net.edupoll.kr.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.TimeCountVo;

@Repository
public class TimeCountDao {

		@Autowired
		SqlSession sqlSession;
		
		
		public List<TimeCountVo> timeCount() {
			
			
			return sqlSession.selectList("statistics.countPerHours");
			
			
		}
}
