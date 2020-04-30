package com.li.demo.component;

import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(ApplicationUtil.pattern);
        Date date = new Date();
        try {
            date = dateFormat.parse(s);
        } catch (ParseException e) {
            System.out.println("转换失败！");
        }
        return date;
    }
}
