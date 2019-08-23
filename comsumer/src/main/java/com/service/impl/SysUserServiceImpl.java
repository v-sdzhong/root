package com.service.impl;


import com.dao.SysUserDao;
import com.entity.SysUser;
import com.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {

  @Autowired
  SysUserDao sysUserDao;

    @Override
    public List<SysUser> findAll() {
        return   sysUserDao.findAll();
    }

  @Override
  public void save(SysUser user) {
    sysUserDao.save(user);
  }

  @Override
  public void update(SysUser user) {
    sysUserDao.saveAndFlush(user);
  }

  @Override
  public void delete(Long id) {
    sysUserDao.deleteById(id);
  }

  @Override
  public SysUser findById(Long id) {
    return sysUserDao.findById(id).get();
  }
}
