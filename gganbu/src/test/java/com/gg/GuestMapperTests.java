package com.gg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gg.mapper.GuestMapper;

@SpringBootTest
public class GuestMapperTests {

    @Autowired
    private GuestMapper guestMapper;

//    @Test
//    public void selectGuest() {
//        List list = guestMapper.getList();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("" + list.get(i));
//        }
//    }
}
