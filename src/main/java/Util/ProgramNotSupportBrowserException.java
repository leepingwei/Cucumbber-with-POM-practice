package Util;

public class ProgramNotSupportBrowserException extends RuntimeException{

    public ProgramNotSupportBrowserException(){
        super();
    }

    public ProgramNotSupportBrowserException(String message){
        super(message);
    }
}
