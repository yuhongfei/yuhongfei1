package dang.test;
public class ReChange
{
    public static void main(String[] args)
    {
        
        //向上类型转换
        Cat cat = new Cat();
        Animal animal = cat;
        animal.sing();

                
        //向下类型转换
        Animal a = new Cat();
        Cat c = (Cat)a;
        c.sing();
        c.eat();
       

    }
}
class Animal
{
    public void sing()
    {
        System.out.println("Animal is singing!");
    }
}
class Dog extends Animal
{
    public void sing()
    {
        System.out.println("Dog is singing!");
    }
}
class Cat extends Animal
{
    public void sing()
    {
        System.out.println("Cat is singing!");
    }
    public void eat()
    {
        System.out.println("Cat is eating!");
    }
}
