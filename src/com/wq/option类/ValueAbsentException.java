package com.wq.option类;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class ValueAbsentException extends Throwable {

    public ValueAbsentException(){
        super();
    }

    public ValueAbsentException(String msg){
        super(msg);
    }

    public String getMessage(){
        return "No value present in the Optional instance";
    }
}
