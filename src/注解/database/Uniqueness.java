//: annotations/database/Uniqueness.java
// Sample of nested annotations
package 注解.database;

public @interface Uniqueness {
  Constraints constraints() default @Constraints(unique=true);
} ///:~
