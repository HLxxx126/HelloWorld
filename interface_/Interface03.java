package com.hspedu.chapter10.interface_;

public class Interface03 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        OracleDB oracleDB = new OracleDB();
        t(mysqlDB);
        t(oracleDB);
    }
    public static void t(DBInterface db){
        db.connect();
        db.close();
    }
}
