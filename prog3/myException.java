package Archive.prog3;

public class myException extends Exception{

    public myException(){
        super();
    }

    public myException(String msg){
        super(msg);
    }

    public void MaxVal(int num){
        if(num>100){
            try{
                throw new Exception("value > 100");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void minVal(int val)throws Exception{
        if(val<20){
            throw new Exception("value is less than 20");
        }
    }

    public void test()throws myException{
        throw new myException("error");
    }

}