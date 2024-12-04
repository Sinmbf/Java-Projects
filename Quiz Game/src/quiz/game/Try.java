package quiz.game;

// Parent class
class ParentClass{
    private int x;
    // Default Constructor
    ParentClass(){
        System.out.println("Default constructor of parent");
    }
    
    // Parameterized Constructor
    ParentClass(int x){
        this.x=x;
    }
}

// Child class
class ChildClass extends ParentClass{
    private int x;
    // Default Constructor
    public ChildClass(){
        System.out.println("Default constructor of class");
    }
    
    // Parameterized Constructor
    public ChildClass(int x){
        super(x);
    }
}

// Main class
public class Try{
    public static void main(String[]args){
        // Create object of child
        ChildClass child1=new ChildClass();
        ChildClass child2=new ChildClass(2);
    }
}