package com.dawnlee.bolg.Util;

import com.alibaba.fastjson.JSON;
import com.dawnlee.bolg.dto.accessTokenDto;
import com.dawnlee.bolg.dto.githubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Component

public class GithubUtils {

    public String getAccessToken(accessTokenDto accessTokenDto){


        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();


        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                System.out.println(string);
                String[] split = string.split("&");

                String s = split[0];
                String[] split1 = s.split("=");
                String token = split1[1];

                System.out.println("++++++++++++++++++++++");
                System.out.println(token);
                System.out.println("++++++++++++++++++++++");
                return token;
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        public githubUser getuser(String access_token){

            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+access_token)
                    .build();

            try {
                Response response = okHttpClient.newCall(request).execute();
                String string = response.body().string();
                //转换为json对象 并且转换为java的累对象
                githubUser githubUser = JSON.parseObject(string, githubUser.class);
                return githubUser;
            } catch (IOException e) {
                e.printStackTrace();
            }
    return null;
        }




    }


