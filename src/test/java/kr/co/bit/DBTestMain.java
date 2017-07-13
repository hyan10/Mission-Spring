package kr.co.bit;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.co.bit.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(locations={"classpath:config/spring/spring-mvc.xml",
								"classpath:config/mybatis/sqlMapConfig.xml",
								"classpath:config/sqlmap/oracle/sqlmap-board.xml"})*/
@ContextConfiguration(locations={"classpath:config/**/*.xml"})  // ** 하위폴더 모두
public class DBTestMain {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void dbtest(){ // 메서드 한글이어도됨
		
	}
	
//	@Test
	public void DB접속테스트() throws Exception{
		System.out.println("ds: "+ds);
		Connection conn = ds.getConnection();
		System.out.println(conn);
		System.out.println(sqlSessionTemplate);
	}
	
//	@Test
	public void 전체게시글조회테스트() throws Exception{
		
		List<BoardVO> list = sqlSessionTemplate.selectList("board.dao.BoardDAO.selectAllBoard");
		for(BoardVO vo : list){
			System.out.println(vo);
		}
	}
	
//	@Test
	public void 게시판상세조회테스트() throws Exception{
		
		BoardVO board = sqlSessionTemplate.selectOne("board.dao.BoardDAO.seletOneByNo", 5);
		System.out.println(board);
	}
	
	@Transactional
	// @Rollback(false) // jUnit에서는 트랜잭션은 무조건 롤백된다. commit하려면 rollback(false) 써줘야함
	@Test
	public void 트랜잭션테스트() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("제ㅗㅁㄱ입니다123");
		board.setWriter("호익");
		board.setContent("ㄴ애ㅛㅇㅇ");
		
		
		sqlSessionTemplate.insert("board.dao.BoardDAO.insertBoard", board);
		board.setNo(41);
		sqlSessionTemplate.update("board.dao.BoardDAO.updateViewCnt", board);
		System.out.println("작업완료");
		
		/*
		 * t_board 테이블에 게시물을 등록하고 41번 게시물의 조회수를 1 증가
		 * 단, 입력과 수정은 동시에 수행 (둘중에 한개만 실행할 수 없음)
		 */
		
		
	}
}
