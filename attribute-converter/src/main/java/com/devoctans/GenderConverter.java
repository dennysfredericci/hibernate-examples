package com.devoctans;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;


@Converter
public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender gender) {
        return gender.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(String code) {
        return Arrays.stream(Gender.values()).filter(gender -> gender.getCode().equals(code))
                .findFirst()
                .orElse(Gender.NOT_AVAILABLE);
    }
}
