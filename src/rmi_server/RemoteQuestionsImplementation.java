/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_server;

import controllers.AnswerController;
import controllers.QuestionController;
import controllers.UserController;
import rmi_interface.RemoteQuestions;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Answer;
import models.User;


public class RemoteQuestionsImplementation extends UnicastRemoteObject implements RemoteQuestions {
    
    public RemoteQuestionsImplementation() throws RemoteException {
        super();
    }

    public RemoteQuestionsImplementation(int i) throws RemoteException {
        super(i);
    }

    public RemoteQuestionsImplementation(int i, RMIClientSocketFactory rmicsf, RMIServerSocketFactory rmissf) throws RemoteException {
        super(i, rmicsf, rmissf);
    }

    @Override
    public int getNumberOfQuestion() throws RemoteException {
        int count = 0;
        try {
            count = QuestionController.getInstance().getQuestionCount();
        } catch (Exception ex) {
            Logger.getLogger(RemoteQuestionsImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public String getQuestion(int questionNumber) throws RemoteException {
        String question = "";
        try {
            question = QuestionController.getInstance().Search(questionNumber);
        } catch (Exception ex) {
            Logger.getLogger(RemoteQuestionsImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return question;
    }

    @Override
    public void setAnswer(int userId, int questionNumber, String answer) throws RemoteException {
        Answer data = new Answer();
        data.setUser_id(userId);
        data.setQuestion_id(questionNumber);
        data.setAnswer(answer);
        data.setDate_time(new Date().toString());
        try {
            AnswerController.getInstance().Save(data);
        } catch (Exception ex) {
            Logger.getLogger(RemoteQuestionsImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String login(String username, String password) throws RemoteException {
        String name = "";

        try {
            name = UserController.getInstance().Login(username, password);
        } catch (Exception ex) {
            Logger.getLogger(RemoteQuestionsImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return name;
    }

    @Override
    public void register(String name, String phone, String username, String password) throws RemoteException {

        User data = new User(0, name, phone, username, password, 0);
        try {
            UserController.getInstance().Save(data);
        } catch (Exception ex) {
            Logger.getLogger(RemoteQuestionsImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
