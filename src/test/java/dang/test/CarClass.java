package dang.test;

public class CarClass {
	public static String type;      //静态属性
	String name;		//非静态属性
	
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        CarClass Car = new CarClass();
        Car.setName("BMW");
        CarClass.type="ACar";
        System.out.println(CarClass.type+": "+Car.getName());
        CarClass Bus = new CarClass();
        Bus.setName("Bens");
        CarClass.type="BCar";
        System.out.println(CarClass.type+": "+Bus.getName());
    }
}

