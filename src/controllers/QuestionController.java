package controllers;

import models.Question;
import database.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionController {

    Connector con = Connector.getInstance();

    private QuestionController() {
    }

    private static final QuestionController obj = new QuestionController();

    public static QuestionController getInstance() {
        return obj;
    }

    public void Save(Question data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO question(question) values ('" + data.getQuestion() + "') ");
    }

    public void Update(Question data) throws Exception {
        con.getConnection();
        con.aud("UPDATE question SET question  = '" + data.getQuestion() + "' WHERE question_id = '" + data.getQuestion_id() + "'");
    }

    public void Delete(Question data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM question WHERE question_id = '" + data.getQuestion_id() + "'");
    }

    public List<Question> SearchAll() throws Exception {
        List<Question> objList = new ArrayList<Question>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM question");
        while (rset.next()) {
            Question obj = new Question();
            obj.setQuestion_id(rset.getInt(1));
            obj.setQuestion(rset.getString(2));
            objList.add(obj);
        }

        return objList;
    }

    public String Search(int questionNo) throws Exception {
        String question = "";
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM question WHERE question_id = '" + questionNo + "'");
        while (rset.next()) {
            question = rset.getString(2);
        }

        return question;
    }

    public int getQuestionCount() throws Exception {
        int count = 0;

        con.getConnection();
        ResultSet rset = con.srh("SELECT COUNT(*)  FROM question");
        if (rset.next()) {
            count = rset.getInt(1);
        }

        return count;
    }

}
