package com.seong.app.model.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private MybatisClientDAO clientDAO;

	@Override
	public List<ClientVO> select() {
		return clientDAO.select();
	}
	@Override
	public int insert(ClientVO vo) {
		int res = 0;
		try {
			clientDAO.insert(vo);
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public int delete(ClientVO vo) {
		int res = 0;
		try {
			clientDAO.delete(vo);
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public int update(ClientVO vo) {
		int res = 0;
		try {
			clientDAO.update(vo);
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public ClientVO login(ClientVO vo) {
		ClientVO res = null;
		try {
			res = clientDAO.login(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}