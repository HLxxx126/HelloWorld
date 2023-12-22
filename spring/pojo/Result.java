package com.itheima.pojo;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Result {
    private Integer code;//1 成功 ，0 失败
    private String mag;//ヒント情報
    private Object data;

    public Result() {
    }

    public Result(Integer code, String mag, Object data) {
        this.code = code;
        this.mag = mag;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(Object data){
        return new Result(1,"sucess",data);
    }
    public static Result success(){
        return new Result(1,"sucess",null);
    }
    public static Result error(String msg){
        return new Result(0,msg,null);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", mag='" + mag + '\'' +
                ", data=" + data +
                '}';
    }
}
