package Archive.prog3;

public class ExceptionA extends Exception {

    public ExceptionA(){
        super();
    }

    public ExceptionA(String msg){
        super(msg);
    }

    public void ExceptionA_Thrower()throws ExceptionA{
        throw new ExceptionA("ExceptionA has been thrown");
    }
}