package com.dxc.empmgt.exceptions;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException (String msg){
        super(msg);
    }
}
