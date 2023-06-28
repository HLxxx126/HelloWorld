package com.hspedu.poly.polyparameter;

public class Test {
    public double showEmpAnnual(Employee e){
        return e.getAnnual();
    }
    public void testWork (Employee e){
        if(e instanceof Worker){
            ((Worker) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        }else {
        }
    }
}
