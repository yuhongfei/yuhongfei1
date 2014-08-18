package dang.test;
//import java.*;
public class Reorder
{
    public static void main(String[] args)
    {
    	int array[]={10,9,8,4,12,13,11,53,71,99,2};
    	Order order = new Order();
    	order.run(array);
    	
    	Order bubble = new Bubble();
    	bubble.run(array);
    	
    	Order select = new Select();
    	select.run(array);

    }
}
class Order
{
    public void run(int[] array)
    {
    	System.out.println("排序前的数组：");
		for(int i=0;i<array.length;i++){
			System.out.print(" "+array[i]);
		};
    }
}
class Bubble extends Order //冒泡排序
{
    public void run(int[] array)
    {
    	for(int i=0;i<array.length;i++){
			for(int j=i;j<array.length;j++){
				if(array[j]<array[i]){
					int change=array[i];
					array[i]=array[j];
					array[j]=change;
				}
			}
		}
    	System.out.println( );
		System.out.println("冒泡排序后的数组：");
		for(int i=0;i<array.length;i++){
			System.out.print(" "+array[i]);
			
		}
    }
}
class Select extends Order //选择排序
{
	public void run(int[] array){
	int len=array.length;
    int temp;
    for(int i=0;i<len;i++)
    {
        temp=array[i];
        int j;
        int Location=i;//最小数的下标
        for(j=i+1;j<len;j++)
        {
           if(array[j]<temp)
           {
               temp=array[j];//取出最小值
               Location=j;//取出最小值所在下标
           }
        }
        array[Location]=array[i];
        array[i]=temp;
     }	
    System.out.println( );
	System.out.println("选择排序后的数组：");
	for(int i=0;i<array.length;i++){
		System.out.print(" "+array[i]);
		
	}
	}
}
    	

