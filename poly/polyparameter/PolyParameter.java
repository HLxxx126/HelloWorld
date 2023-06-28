package com.hspedu.poly.polyparameter;

public class PolyParameter {
    public static void main(String[] args) {
//        Employee[] e = new Employee[2];
//        e[0] = new Manager("老王",8000,20000);
//        e[1] = new Worker("小明",3000);
//        for (int i = 0; i < e.length; i++) {
//            System.out.println(e[i].getAnnual());
//            if(e[i] instanceof Manager) {
//                ((Manager) e[i]).manage();
//            } else if (e[i] instanceof Worker) {
//                ((Worker)e[i]).work();
//            }
//        }
        Worker worker = new Worker("小明",3000);
        Manager manager = new Manager("老王",8000,20000);
        Test test = new Test();
        System.out.println(test.showEmpAnnual(worker));
        System.out.println(test.showEmpAnnual(manager));
        manager.manage();
        worker.work();

    }
}
