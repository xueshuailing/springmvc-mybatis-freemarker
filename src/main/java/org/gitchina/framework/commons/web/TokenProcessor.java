package org.gitchina.framework.commons.web;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
 
 
public class TokenProcessor {
    /*
     * 1.把构造函数私有
     * 2.自己创建一个
     * 3.对外暴露一个方法，允许获取上面创建的对象
     * */
    private static final TokenProcessor instance=new TokenProcessor();
    private TokenProcessor(){}
    public static TokenProcessor getInstance()
    {
        return instance;
    }
    public String generateToken()
    {
        String token=System.currentTimeMillis()+new Random().nextInt()+"";
        try {
            MessageDigest md=MessageDigest.getInstance("md5");
            byte[] md5=md.digest(token.getBytes());
            //base64编码
            Base64 encoder=new Base64();
            return encoder.encodeAsString(md5);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }
     
}