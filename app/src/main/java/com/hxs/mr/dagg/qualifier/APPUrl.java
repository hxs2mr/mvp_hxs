package com.hxs.mr.dagg.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:区分httpmodule 中的provide   注：当app的链接地址不统一的时候 需要在httmodule重新添加一个provide  并重新创建注解一个@Qualifier文件
 * 创建时间:  2018\6\27 0027 11:18
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface APPUrl {
}
