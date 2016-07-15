package newDatatypes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestingObjectRefection {
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void test() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException{
		Integer arg = new Integer(14);
		Class def = null;
		try {
			def = Class.forName("newDatatypes.NodeforReflection");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class[] argclass = new Class[]{int.class};
		Constructor constructor = def.getConstructor(argclass);
		NodeforReflection node = (NodeforReflection) constructor.newInstance(arg);
		
		Field f = def.getDeclaredField("data1");
		f.setAccessible(true);
		int val1 = (int) f.get(node);
		Method m = def.getDeclaredMethod("getval");
		int val = (int)m.invoke(node);
		
		System.out.println("object reflection on node, value: "+ val1);
	}
}
