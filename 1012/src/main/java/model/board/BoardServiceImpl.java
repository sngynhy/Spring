package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
		
	}
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		try {
			return boardDAO.getBoardList(vo);
		} catch(Exception e) {
			return null;
		}
		
	}
}
