package com.hspedu.chapter10.interface_;

public class Computer {
    public void work(UsbInterface usbInterface){
        usbInterface.start();
        usbInterface.stop();
    }
}
