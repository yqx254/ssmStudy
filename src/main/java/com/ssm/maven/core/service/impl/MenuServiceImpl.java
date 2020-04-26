package com.ssm.maven.core.service.impl;

import com.ssm.maven.core.dao.MenuDao;
import com.ssm.maven.core.entity.Menu;
import com.ssm.maven.core.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenuList() {
        return  menuDao.getMenuList();
    }
}
