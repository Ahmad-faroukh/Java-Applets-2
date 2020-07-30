package Archive.prog3;

public class ExceptionC extends ExceptionB {

    public ExceptionC(){
        super();
    }

    public ExceptionC(String msg){
        super(msg);
    }

    public void ExceptionC_Thrower()throws ExceptionC{
        throw new ExceptionC("ExceptionC has been thrown");
    }
}