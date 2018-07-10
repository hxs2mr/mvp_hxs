package com.hxs.mr.dagg.module;

import android.util.Log;

import com.hxs.mr.app.Constans;
import com.hxs.mr.appmodule.http.api.APPapi;
import com.hxs.mr.dagg.qualifier.APPUrl;
import com.hxs.mr.utils.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者： XS
 * 邮箱：1363826037@qq.com
 * 描述:网络请求module
 * 创建时间:  2018\6\27 0027 10:26
 */

@Module
public class HttpModule {
    //Observable<LYLResponse<String>>  clearMyDyPushList(@Field("action")String action);//清楚推送过来的数据

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder(){
        return  new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder()
    {
        return  new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder)
    {
        /*服务响应的json*/
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("SERVER","Server"+new Date()+":"+message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        builder.addInterceptor(httpLoggingInterceptor);

        File cacheFile  = new File(Constans.PATH_SDCARD);
        Cache cache = new Cache(cacheFile,1024*1024*58);
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if(!SystemUtil.isNetworkConnected())//检查网络是否可以
                {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if(SystemUtil.isNetworkConnected())
                {
                    int max = 0;//有网络时不缓存  保存时间为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + max)
                            .removeHeader("Pragma")
                            .build();
                }else {
                    //无网络时，设置缓存为4周
                    int max = 60*60*24*28;
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + max)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        //设置统一的请求头参数
        builder.addNetworkInterceptor(interceptor);
        builder.addInterceptor(interceptor);
        //设置缓存
        builder.cache(cache);

        //设置超时

        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重链
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    private Retrofit createRetrofit(Retrofit.Builder builder,OkHttpClient client,String host){
        return builder
                .baseUrl(host)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //Api接口

    @Singleton
    @Provides
    @APPUrl //可定义其他的地址
    Retrofit provideAPPRetrofit(Retrofit.Builder builder,OkHttpClient client) {
        return createRetrofit(builder,client, APPapi.HOST);
    }
    @Singleton
    @Provides
    APPapi provideAPPService(@APPUrl Retrofit retrofit)
    {
        return retrofit.create(APPapi.class);
    }
}
