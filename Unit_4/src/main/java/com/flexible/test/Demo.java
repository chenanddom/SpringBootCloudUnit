package com.flexible.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flexible.bean.Peron;
import com.flexible.bean.PersonEntity;
import com.google.protobuf.InvalidProtocolBufferException;

public class Demo {

    public static void main(String[] args) throws InvalidProtocolBufferException, JsonProcessingException {
        PersonEntity.Person.Builder builder = PersonEntity.Person.newBuilder();
        builder.setEmail("772571631@qq.com");
        builder.setId(1);
        builder.setName("zhangsan");
        PersonEntity.Person person = builder.build();
        System.out.println("before :"+ person.toString());

        System.out.println("===========Person Byte==========");
        for(byte b : person.toByteArray()){
            System.out.print(b);
        }
        System.out.println();
        System.out.println(person.toByteString());
        System.out.println("================================");

        byte[] bytes = person.toByteArray();
        System.out.println("length:"+bytes.length);
        PersonEntity.Person person1 = PersonEntity.Person.parseFrom(bytes);
        System.out.println("after :" +person1.toString());
//        -------------------------------------------------------------------------------------------------------------
        Peron peron = new Peron();
        peron.setEmail("772571631@qq.com");
        peron.setId(1);
        peron.setName("zhangsan");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(peron);
        System.out.println("content:"+jsonStr);
        System.out.println("size:"+jsonStr.getBytes().length);
    }
}
