package com.service;

import com.entity.SysUser;

import java.util.List;

public interface ISysUserService {
        public List<SysUser> findAll();
        public  void  save(SysUser user);
        public  void  update(SysUser user);
        public  void delete(Long id);
        public  SysUser findById(Long id);
}
