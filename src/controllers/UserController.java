
package controllers;

import models.User;
import database.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    Connector con = Connector.getInstance();

    private UserController() {
    }

    private static final UserController obj = new UserController();

    public static UserController getInstance() {
        return obj;
    }

    public void Save(User data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO user(name,phone,username,password,loyalty) values ('" + data.getName() + "','" + data.getPhone() + "','" + data.getUsername() + "','" + data.getPassword() + "','" + data.getLoyalty() + "') ");
    }

    public void Update(User data) throws Exception {
        con.getConnection();
        con.aud("UPDATE user SET name  = '" + data.getName() + "',phone  = '" + data.getPhone() + "',username  = '" + data.getUsername() + "',password  = '" + data.getPassword() + "',loyalty  = '" + data.getLoyalty() + "' WHERE user_id = '" + data.getUser_id() + "'");
    }

    public void Delete(User data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM user WHERE user_id = '" + data.getUser_id() + "'");
    }

    public List<User> SearchAll() throws Exception {
        List<User> objList = new ArrayList<User>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM user");
        while (rset.next()) {
            User obj = new User();
            obj.setUser_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setPhone(rset.getString(3));
            obj.setUsername(rset.getString(4));
            obj.setPassword(rset.getString(5));
            obj.setLoyalty(rset.getInt(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<User> Search(User data) throws Exception {
        List<User> objList = new ArrayList<User>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM user WHERE user_id = '" + data.getUser_id() + "'");
        while (rset.next()) {
            User obj = new User();
            obj.setUser_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setPhone(rset.getString(3));
            obj.setUsername(rset.getString(4));
            obj.setPassword(rset.getString(5));
            obj.setLoyalty(rset.getInt(6));
            objList.add(obj);
        }

        return objList;
    }

    public String Login(String username, String password) throws Exception {
        String name = "";
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'");
        if (rset.next()) {
            name = rset.getInt(1) + "_" + rset.getString(2);
        }

        return name;
    }

}
