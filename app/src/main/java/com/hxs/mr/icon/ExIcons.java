package com.hxs.mr.icon;

import com.joanzapata.iconify.Icon;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:字体图标
 * 创建时间:  2018\6\28 0028 10:18
 */
public enum  ExIcons implements Icon{

    /*在阿里图标发在购物车里面（多张）  然后统一添加在里面下载代码   获取下载的.ttf文件放在assets中    再将&#xe601 &#xe63c替换成 下面的*/
    icon_zhongguofengjianzhu('\ue601'),
    icon_xihuan('\ue63c'),
    icon_fabu('\ue66f'),
    icon_zhuye_chengchangjilu('\ue690'),
    icon_diqiu('\ue62e');

    private char character;
    ExIcons(char character){
        this.character = character;
    }
    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
