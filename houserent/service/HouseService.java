package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.viwe.HouseView;

public class HouseService {
    private House[] houses;//保存House对象
    private int houseNums = 1;
    private int idCounter = 1;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "jack", "112", "海淀区", 2000, "未出租");
    }

    public House[] list() {
        return houses;
    }

    public boolean add(House newHouse) {
        if (houseNums == houses.length) {
            System.out.println("数组已满，不能再添加了。。。");
            return false;
        }
        houses[houseNums++] = newHouse;
        idCounter++;
        newHouse.setId(idCounter);
        return true;
    }

    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[houseNums - 1] = null;
        houseNums--;
        return true;
    }

    public House findId(int findId) {
        for (int i = 0; i < houseNums; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }
}
