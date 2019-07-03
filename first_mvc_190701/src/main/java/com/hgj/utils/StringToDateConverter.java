package com.hgj.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if(s == null){
            throw new RuntimeException("请输入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = df.parse(s);
            return parse;
        } catch (ParseException e) {
            throw new RuntimeException("数据转换异常");
        }

    }
}
