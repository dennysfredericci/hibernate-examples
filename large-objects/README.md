# Large Objects

In this hibernate example you can see how store large objects(file or large text) we basically have 2 approaches.

1 - The easy approach

    byte[] and String

2 - A better performance approach

    java.sql.Blob and java.sql.Clob

DISCLAIMER: Always use other entity to than your business entity to save large objects.
