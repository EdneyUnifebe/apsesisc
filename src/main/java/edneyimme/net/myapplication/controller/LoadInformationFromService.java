package edneyimme.net.myapplication.controller;

import java.util.ArrayList;

import edneyimme.net.myapplication.dao.Users;

public class LoadInformationFromService {

    public ArrayList<Users> getUserInformationFromService(){
        ArrayList<Users> usersList = new ArrayList<Users>();
        for (int indice =0; indice < 10; indice++) {
            Users u = new Users(""+indice, "Nome " + indice);
            usersList.add(u);
        }
        return usersList;
    }
}
