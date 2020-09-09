import java.lang.reflect.Field;

public class SafeKlass {
    private static final String CONSTANT = "You can not change me, I'm a constant expression!";
//    public static final Integer NOT_SO_CONSTANT = 10; // this update will persist through the entire code
    public static final int NOT_SO_CONSTANT = 10; // this update will **NOT** persist through the entire code

    public static String getConstant()
    {
        return CONSTANT;
    }

    public static String getConstantReflection()
    {
        try {
            final Field fld = SafeKlass.class.getDeclaredField( "CONSTANT" );
            return (String) fld.get( null );
        } catch (NoSuchFieldException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public static int getNotSoConstant()
    {
        return NOT_SO_CONSTANT;
    }
}