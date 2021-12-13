package com.seong.app.model.client;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisClientDAO {
   public List<ClientVO> select();
   public ClientVO login(ClientVO vo);
   public int insert(ClientVO vo);
   public int delete(ClientVO vo);
   public int update(ClientVO vo);
}