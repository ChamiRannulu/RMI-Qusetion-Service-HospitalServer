
package controllers;

import models.Answer;
import database.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnswerController {

    Connector con = Connector.getInstance();

    private AnswerController() {
    }

    private static final AnswerController obj = new AnswerController();

    public static AnswerController getInstance() {
        return obj;
    }

    public void Save(Answer data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO answer(question_id,user_id,answer,date_time) values ('" + data.getQuestion_id() + "','" + data.getUser_id() + "','" + data.getAnswer() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Answer data) throws Exception {
        con.getConnection();
        con.aud("UPDATE answer SET question_id  = '" + data.getQuestion_id() + "',user_id  = '" + data.getUser_id() + "',answer  = '" + data.getAnswer() + "',date_time  = '" + data.getDate_time() + "' WHERE answer_id = '" + data.getAnswer_id() + "'");
    }

    public void Delete(Answer data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM answer WHERE answer_id = '" + data.getAnswer_id() + "'");
    }

    public List<Answer> SearchAll() throws Exception {
        List<Answer> objList = new ArrayList<Answer>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM answer");
        while (rset.next()) {
            Answer obj = new Answer();
            obj.setAnswer_id(rset.getInt(1));
            obj.setQuestion_id(rset.getInt(2));
            obj.setUser_id(rset.getInt(3));
            obj.setAnswer(rset.getString(4));
            obj.setDate_time(rset.getString(5));
            objList.add(obj);
        }

        return objList;
    }

    public List<Answer> Search(Answer data) throws Exception {
        List<Answer> objList = new ArrayList<Answer>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM answer WHERE answer_id = '" + data.getAnswer_id() + "'");
        while (rset.next()) {
            Answer obj = new Answer();
            obj.setAnswer_id(rset.getInt(1));
            obj.setQuestion_id(rset.getInt(2));
            obj.setUser_id(rset.getInt(3));
            obj.setAnswer(rset.getString(4));
            obj.setDate_time(rset.getString(5));
            objList.add(obj);
        }

        return objList;
    }

    public int getCount(String value) throws Exception {
        int count = 0;

        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM answer WHERE answer = '" + value + "'");
        while (rset.next()) {
            count++;
        }

        return count;
    }

}
