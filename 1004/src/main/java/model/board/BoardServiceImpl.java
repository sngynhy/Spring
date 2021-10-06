package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seong.app.common.LogAdvice;

@Service("boardService") // Service 객체라는 것을 명시하기 위해 Service 어노테이션 사용 (Component의 하위 어노테이션)
public class BoardServiceImpl implements BoardService {
	
	@Autowired // 의존성 주입
	private BoardDAO boardDAO;
	
	private LogAdvice logAdivce;
//	private LogPlusAdvice logPlusAdivce;
	// 기존의 OOP 언어 체계에서 AOP가 갖는 한계 : 위와 같이 객체 변경 시 모든 코드를 일일이 바꾸어야 한다는 점!
	// 스프링은 이런 한계를 극복하기 위해 컨테이너를 사용!
	
	public BoardServiceImpl() { // 생성자 주입
		this.logAdivce = new LogAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO invo) {
		logAdivce.printLog();
//		logPlusAdivce.printPlusLog();
		boardDAO.insertBoard(invo);
	}
	@Override
	public void updateBoard(BoardVO invo) {
		logAdivce.printLog();
//		logPlusAdivce.printPlusLog();
		boardDAO.updateBoard(invo);
	}
	@Override
	public void deleteBoard(BoardVO invo) {
		logAdivce.printLog();
//		logPlusAdivce.printPlusLog();
		boardDAO.deleteBoard(invo);
	}
	@Override
	public List<BoardVO> getBoardList(BoardVO invo) {
		logAdivce.printLog();
//		logPlusAdivce.printPlusLog();
		return boardDAO.getBoardList(invo);
	}
	@Override
	public BoardVO getBoard(BoardVO invo) {
		logAdivce.printLog();
//		logPlusAdivce.printPlusLog();
		return boardDAO.getBoard(invo);
	}
}
