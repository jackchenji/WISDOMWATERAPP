package com.cdwm.app.util;

import com.cdwm.app.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuConstants {
    private static List<Map<String,Object>> menus = new ArrayList<>();

    //获得菜单列表
    public static List<Map<String,Object>> getMenus(){
        //调用接口获取权限

        //1.业扩报装
        Map<String, Object> menuObj01 = new HashMap<>();
        menuObj01.put("title", "业扩报装");
        //
        List<Map<String, Object>> menu01List = new ArrayList<Map<String, Object>>();

        Map<String, Object> menu01 = new HashMap<>();
        menu01.put("menuId", "1001");
        menu01.put("menuName", "待办事宜");
        menu01.put("icon", R.drawable.icon_1001);
        menu01List.add(menu01);

        Map<String, Object> m1002 = new HashMap<>();
        m1002.put("menuId", "1002");
        m1002.put("menuName", "发起流程");
        m1002.put("icon", R.drawable.icon_1002);
        menu01List.add(m1002);

        Map<String, Object> m1003 = new HashMap<>();
        m1003.put("menuId", "1003");
        m1003.put("menuName", "我的请求");
        m1003.put("icon", R.drawable.icon_1003);
        menu01List.add(m1003);

        Map<String, Object> m1004 = new HashMap<>();
        m1004.put("menuId", "1004");
        m1004.put("menuName", "已办事宜");
        m1004.put("icon", R.drawable.icon_1004);
        menu01List.add(m1004);

        Map<String, Object> m1005 = new HashMap<>();
        m1005.put("menuId", "1005");
        m1005.put("menuName", "办结事宜");
        m1005.put("icon", R.drawable.icon_1005);
        menu01List.add(m1005);

        menuObj01.put("menuList", menu01List);
        menus.add(menuObj01);

        //经营情况
        Map<String, Object> menuObj02 = new HashMap<>();
        menuObj02.put("title", "经营情况");
        //
        List<Map<String, Object>> menu02List = new ArrayList<Map<String, Object>>();
        Map<String, Object> menu21 = new HashMap<>();
        menu21.put("menuId", "2001");
        menu21.put("menuName", "营收报表");
        menu21.put("icon", R.drawable.icon_2001);
        menu02List.add(menu21);

        Map<String, Object> menu22 = new HashMap<>();
        menu22.put("menuId", "2002");
        menu22.put("menuName", "水量分析");
        menu22.put("icon", R.drawable.icon_2002);
        menu02List.add(menu22);

        Map<String, Object> menu23 = new HashMap<>();
        menu23.put("menuId", "2003");
        menu23.put("menuName", "回款率");
        menu23.put("icon", R.drawable.icon_2003);
        menu02List.add(menu23);

        Map<String, Object> menu24 = new HashMap<>();
        menu24.put("menuId", "2004");
        menu24.put("menuName", "欠费情况");
        menu24.put("icon", R.drawable.icon_2004);
        menu02List.add(menu24);

        Map<String, Object> menu25 = new HashMap<>();
        menu25.put("menuId", "2005");
        menu25.put("menuName", "抄表统计");
        menu25.put("icon", R.drawable.icon_2005);
        menu02List.add(menu25);

        Map<String, Object> menu26 = new HashMap<>();
        menu26.put("menuId", "2006");
        menu26.put("menuName", "用户统计");
        menu26.put("icon", R.drawable.icon_2006);
        menu02List.add(menu26);

        Map<String, Object> menu27 = new HashMap<>();
        menu27.put("menuId", "2007");
        menu27.put("menuName", "用水性质统计");
        menu27.put("icon", R.drawable.icon_2007);
        menu02List.add(menu27);

        Map<String, Object> menu28 = new HashMap<>();
        menu28.put("menuId", "2008");
        menu28.put("menuName", "水表类型统计");
        menu28.put("icon", R.drawable.icon_2008);
        menu02List.add(menu28);

        menuObj02.put("menuList", menu02List);
        menus.add(menuObj02);

        //3.小咪咪菜单
        Map<String, Object> menuObj03 = new HashMap<>();
        menuObj03.put("title", "小咪咪");
        //
        List<Map<String, Object>> menu03List = new ArrayList<Map<String, Object>>();
        Map<String, Object> menu31 = new HashMap<>();
        menu31.put("menuId", "200001");
        menu31.put("menuName", "小咪咪菜单1");
        menu03List.add(menu31);

        Map<String, Object> menu32 = new HashMap<>();
        menu32.put("menuId", "200002");
        menu32.put("menuName", "小咪咪菜单2");
        menu03List.add(menu32);

        menuObj03.put("menuList", menu03List);
        menus.add(menuObj03);

        //4.江胖子菜单
        Map<String, Object> menuObj04 = new HashMap<>();
        menuObj04.put("title", "江胖子");
        //
        List<Map<String, Object>> menu04List = new ArrayList<Map<String, Object>>();
        Map<String, Object> menu41 = new HashMap<>();
        menu41.put("menuId", "200001");
        menu41.put("menuName", "江胖子菜单1");
        menu04List.add(menu41);

        menuObj04.put("menuList", menu04List);
        menus.add(menuObj04);

        return menus;
    }
}
