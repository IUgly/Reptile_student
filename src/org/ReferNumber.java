package org;

import org.dao.namePointxhDao;

public class ReferNumber {

    public static String Refer(String name){
        namePointxhDao np = new namePointxhDao();
        String Number = np.namePointxh(name);
        return Number.substring(4,14);
    }
    public static void main(String[] args){
        String name = "匡俊霖";
        System.out.println(Refer(name));
    }
}
