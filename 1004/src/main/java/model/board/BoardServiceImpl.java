package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService") // Service ��ü��� ���� ����ϱ� ���� Service ������̼� ��� (Component�� ���� ������̼�)
public class BoardServiceImpl implements BoardService {
	
	@Autowired // ������ ����
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO invo) {
		boardDAO.insertBoard(invo);
	}
	@Override
	public void updateBoard(BoardVO invo) {
		boardDAO.updateBoard(invo);
	}
	@Override
	public void deleteBoard(BoardVO invo) {
		boardDAO.deleteBoard(invo);
	}
	@Override
	public List<BoardVO> getBoardList(BoardVO invo) {
		return boardDAO.getBoardList(invo);
	}
	@Override
	public BoardVO getBoard(BoardVO invo) {
		return boardDAO.getBoard(invo);
	}
}
