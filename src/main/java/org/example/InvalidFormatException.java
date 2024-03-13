package org.example;

public class InvalidFormatException extends NumberFormatException{
    public InvalidFormatException(String str){
        super(str);
    }
}
