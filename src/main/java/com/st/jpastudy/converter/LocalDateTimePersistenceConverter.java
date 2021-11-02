package com.st.jpastudy.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.util.Date;

import static java.time.Instant.ofEpochMilli;
import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneId.systemDefault;

/**
 * JPA에서 시간을 관여할 때 Date, Calendar만 지원을 하는데
 *  LocalDate같은 최신의 시간관련API를 사용할 때
 *  Date나 Calendar로 convert를 해야한다.
 */
@Converter
public class LocalDateTimePersistenceConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(systemDefault()).toInstant());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        return ofInstant(ofEpochMilli(date.getTime()), systemDefault());
    }
}
