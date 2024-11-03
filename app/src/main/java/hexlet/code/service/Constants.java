package hexlet.code.service;

public final class Constants {
     public static final int MIN_RANDOM = -100;
     public static final int MAX_RANDOM = 100;
     public static final int MAX_ADDITIONAL_LENGTH = 6;
     public static final int MIN_LENGTH = 5;
     public static final int MAX_LENGTH = 10;

     private Constants() {
          throw new UnsupportedOperationException("This is a constants class and cannot be instantiated");
     }
}
