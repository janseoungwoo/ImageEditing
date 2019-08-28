package org.spring.img.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.img.domain.BoardVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private String name = "org.spring.img.mappers.boardMapper.";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(name+"create", vo);

	}

	@Override
	public BoardVO read(int bno) throws Exception {
		
		return session.selectOne(name + "read",bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(name + "update",vo);

	}

	@Override
	public void delete(int bno) throws Exception {
		session.delete(name + "delete",bno);
	}

}
