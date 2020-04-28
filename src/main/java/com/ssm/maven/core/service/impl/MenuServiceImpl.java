package com.ssm.maven.core.service.impl;

import com.ssm.maven.core.dao.MenuDao;
import com.ssm.maven.core.entity.Menu;
import com.ssm.maven.core.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenuList() {
        List<Menu> mList = menuDao.getMenuList();

        Map<String, Menu []> menuMap = new HashMap<>(64);

        for(Menu menu : mList){
            if(!"0".equals(menu.getParentId())){

            }
        }
        return  menuDao.getMenuList();
    }
}
