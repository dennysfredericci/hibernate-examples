# Attribute Converter

In this hibernate example you can see how to use an attribute converter

This is pretty useful when Database Administrators enforce developers to use some set of data.

Let's say we have an enumeration Gender(MALE, FEMALE and UNKNOWN) and your Database Administrator told you to use 'M' for MALE, 'F' for FEMALE and 'U' for UNKNOWN.

So to achieve this goal you have:

1 - Implements the interface AttributeConverter

```
public interface AttributeConverter<X,Y> {
    public Y convertToDatabaseColumn (X attribute);
    public X convertToEntityAttribute (Y dbData);
}
```

2 - Add your implementation using the annotation @Convert

```
@Convert(converter = GenderConverter.class)
private Gender gender;
```

You can skip that part if you add the annotation @Converter(autoApply = true) in your implementation
