package com.devoctans;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.getCode();
    }

    @Override
    public Status convertToEntityAttribute(String code) {
        return Arrays.stream(Status.values()).filter(status -> status.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to create Status from Code: '" + code + "'"));
    }
}
