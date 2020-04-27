package com.ssm.maven.core.service.impl;

import com.ssm.maven.core.dao.MenuDao;
import com.ssm.maven.core.entity.Menu;
import com.ssm.maven.core.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenuList() {
        List<Menu> mList = menuDao.getMenuList();
        HashMap<String, Object []>result = new HashMap<>(128);
        for(Menu menu : mList){

        }
        return  menuDao.getMenuList();
    }
}
