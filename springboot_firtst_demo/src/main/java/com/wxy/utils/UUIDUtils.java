package com.wxy.utils;

import java.util.UUID;

/**

* @Description:使用UUIDUtils生产发送给用户的邮箱验证码

*/

public class UUIDUtils {
   public static String getUUID(){
       String uuid = UUID.randomUUID().toString().replace("-", "");
       String substring = uuid.substring(uuid.length() - 6);
       return substring;
  }

}