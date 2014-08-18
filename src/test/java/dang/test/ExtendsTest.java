package dang.test;

class Fathers {    
    public static int x=2; //第三步，初始化子类前，先初始化父类
    private int y=2;      //第四步   
    protected int z;      //第五步  
    Fathers(){            // 第六步
        x=x+1;    			//第七步
        showX();        //第八步，子类实例方法覆盖了父类实例方法，所以调用子类方法
    }    
    public void showX(){    
        System.out.println("Father.x="+x);    
    }    
    public int getY(){    
     return y;    
    }    
   
}    
   
class Child extends Fathers {    
  //      int x=8;
    Child(int x){    
        x=x+8;                 //第十步 因为子类未初始化X，子类自有的x=x+8不执行，x=3
        showX(); 				//第十一步，调用子类方法  打印Child.x=3
    }    
    public void showX(){    
        System.out.println("Child.x="+x);    //第九步，打印Child.x=3
    }    
    public int getY(){   
   
     System.out.println("Child.y="+(super.getY()+x));    //第十二步 y=2,x=3
     return super.getY()+x;    
    }    
   
}
public class ExtendsTest {    
    public static void main(String[] args){    //第一步主方法
        Child Child=new Child(0);         		//第二步 实例化
       int y=Child.getY();    					//第十二步 实例化y,并调用getY()
    }    
   
} 