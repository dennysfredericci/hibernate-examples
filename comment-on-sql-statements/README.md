# Comments on SQL Statements

In this hibernate example you can see how to add comments on sql statements.

This is pretty useful to identify sql statements on logs.

To enable this feature you have to follow 3 steps:

1 - Enable sql statements logging:

```
log4j.logger.org.hibernate.SQL=DEBUG
```

2 - Enable sql comments

```
<property name="hibernate.use_sql_comments" value="true" />
```

3 - For each statement set a hint comment:

```
query.setHint("org.hibernate.comment", "YOUR_COMMENT");
```