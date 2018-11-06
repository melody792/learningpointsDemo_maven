package com.pzb.designModel;

public final class Sington {
    public static final Sington INSTANCE = new Sington();//只被实例化一次
    private Sington() { }//构造函数私有化 保证此类外不能再被实例，保证单例,只能在本类中new
    public void leaveTheBuilding() {
        System.out.println("This is singleton.");
    }

    public Sington(String s){

    }
    public static Sington getInstance(){
        return INSTANCE;
    }
    public static void main(String[] args) {
        Sington elvis = Sington.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
