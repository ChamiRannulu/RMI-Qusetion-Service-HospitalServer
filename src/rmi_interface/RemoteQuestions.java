/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RemoteQuestions extends Remote{
    
    public String login(String username, String password) throws RemoteException;
    
    public void register(String name, String phone, String username, String password) throws RemoteException;

    public int getNumberOfQuestion() throws RemoteException;

    /*
     * get question count from server
     * @parameter send null to the server
     * @return respond from server
     * @throws RemoteException
     */
    public String getQuestion(int questionNumber) throws RemoteException;

    /*
     * get question from server
     * @parameter int question number
     * @return respond from server
     * @throws RemoteException
     */
    
    public void setAnswer(int userId, int questionNumber, String answer) throws RemoteException;

    /*
     * send answer to the server
     * @parameter question number and string answer
     * @return respond from server 
     * @throws RemoteException
     */
}
