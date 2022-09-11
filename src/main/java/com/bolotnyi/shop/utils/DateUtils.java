package com.bolotnyi.shop.utils;

import com.bolotnyi.shop.model.exception.BusinessException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String PATTERN = "dd.MM.yyyy";

    public static Date getDateByString(String date) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(PATTERN);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new BusinessException("Указан неправильный формат даты: " + date);
        }
    }
}
