package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seong.app.common.LogAdvice;

@Service("boardService") // Service ��ü��� ���� ����ϱ� ���� Service ������̼� ��� (Component�� ���� ������̼�)
public class BoardServiceImpl implements BoardService {
	
	@Autowired // ������ ����
	private BoardDAO boardDAO;
	
	private LogAdvice logAdivce;
//	private LogPlusAdvice logPlusAdivce;
	// ������ OOP ��� ü�迡�� AOP�� ���� �Ѱ� : ���� ���� ��ü ���� �� ��� �ڵ带 ������ �ٲپ�� �Ѵٴ� ��!
	// �������� �̷� �Ѱ踦 �غ��ϱ� ���� �����̳ʸ� ���!
	
	public BoardServiceImpl() { // ������ ����
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
