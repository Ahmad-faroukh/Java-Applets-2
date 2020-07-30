package Archive.prog3;

public class ExceptionB extends ExceptionA {

    public ExceptionB(){
        super();
    }

    public ExceptionB(String msg){
        super(msg);
    }

    public void ExceptionB_Thrower()throws ExceptionB{
        throw new ExceptionB("ExceptionB has been thrown");
    }

}