package com.wxy;

import cn.dsna.util.images.ValidateCode;
import com.wxy.mapper.UserMapper;
import com.wxy.utils.UUIDUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@SpringBootTest
class SpringbootFirtstDemoApplicationTests {



    @Test
    void testUUID(){
        String uuid = UUIDUtils.getUUID();
        System.out.println(uuid);
    }

    @Test
    void ValidateCode() throws Exception {
        ValidateCode vc = new ValidateCode(100,30,4,50);
        System.out.println(vc.getCode());
        vc.write(new FileOutputStream("E:\\my.png"));

    }
}
