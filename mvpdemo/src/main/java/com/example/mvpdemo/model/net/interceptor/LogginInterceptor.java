package com.example.mvpdemo.model.net.interceptor;

import com.example.mvpdemo.util.LogUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public class LogginInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        LogUtil.d(String.format("Sending Request %s on %n %s",request.url(), request.headers()));
        FormBody requestBody = (FormBody) request.body();
        HashMap<String,String> params = new HashMap<>();
        for (int i = 0; i < requestBody.size(); i++) {
            params.put(requestBody.encodedName(i), requestBody.encodedValue(i) + "\n");
        }
        LogUtil.d(params.toString());
        //处理响应
        Response response = chain.proceed(request);
        LogUtil.d(response.code()+"");
        long t2 = System.nanoTime();
        ResponseBody responseBody = response.body();
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();
        MediaType contentType = responseBody.contentType();
        Charset charset = contentType.charset(Charset.forName("UTF-8"));
        LogUtil.json(buffer.clone().readString(charset));
        return response;
    }
}
