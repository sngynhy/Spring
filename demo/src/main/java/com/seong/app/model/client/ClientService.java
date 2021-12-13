package com.seong.app.model.client;

import java.util.List;

public interface ClientService {
   public List<ClientVO> select();
   public ClientVO login(ClientVO vo);
   public int insert(ClientVO vo);
   public int delete(ClientVO vo);
   public int update(ClientVO vo);
}
