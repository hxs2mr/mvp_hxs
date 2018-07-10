package com.hxs.mr_base;

import android.os.Environment;

import java.io.File;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:
 * 创建时间:  2018\6\27 0027 10:57
 */
public class Constans {
    public static final String PROJECT_NAME = "HXS";
    public static final String DELITE = "SS";
    /*缓存路径*/
    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory()
            .getAbsolutePath() + File.separator + PROJECT_NAME + File.separator + "hxs";
}
