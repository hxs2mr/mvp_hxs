package com.hxs.mr.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述: 字体图标替换module
 * 创建时间:  2018\6\28 0028 10:18
 */
public class FontEcModule implements IconFontDescriptor{

    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return ExIcons.values();
    }
}
