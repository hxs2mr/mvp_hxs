package com.hxs.mr.appmodule.db;

/**
 * **********************
 * 功 能:数据库操作基类
 * 创建人:
 * 邮  箱:itisivip@qq.com
 * 创建时间:2017/7/5 17:27

 * *********************
 */

public interface DBHelper {
    /**
     * 例如
     * 查询 阅读记录
     * @param id
     * @return
     */
    boolean queryNewsId(int id);
    void closeDB();
    int test_insert();
    int test_delete();
    int test_update();
    int test_select();

}
