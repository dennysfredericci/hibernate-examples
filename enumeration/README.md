# Enumeration

In this hibernate example you can see how to handle enumeration on entities.

You basically have to use  the annotation @Enumerated

1 - Mapping an enumeration to persist the enumeration name:

```
@Enumerated(EnumType.STRING)
private Status statusName;
```


2 - Mapping an enumeration to persist the ordinal number:

```
@Enumerated(EnumType.ORDINAL)
private Status statusOrdinal;
```

DISCLAIMER: Try to avoid much as possible to use this approach!
