import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {
		try {
			ClassLoader loader = Main.class.getClassLoader();
			Class carClass = loader.loadClass("Car");

			Constructor constructor = carClass.getConstructor(null);

			Car car = (Car) constructor.newInstance(null);

			// Field field = carClass.getField("color"); getField method can only get the field specified with public

			Field fieldColor = carClass.getDeclaredField("color");
			fieldColor.setAccessible(true);
			fieldColor.set(car, "yellow");
			
			// Method method = carClass.getMethod("setColor", String.class);; getMethod method can only get the method specified with public
			Method method = carClass.getMethod("setColor", String.class);
			method.invoke(car, "black");

			Method methodDrive = carClass.getDeclaredMethod("driveCar", double.class, String.class);
			Class returnClass = methodDrive.getReturnType();
			System.out.println(returnClass);
			methodDrive.setAccessible(true);
			String returnValue = (String) methodDrive.invoke(car, 185, "str");

			System.out.println(returnValue);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
