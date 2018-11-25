/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiexample;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
/**
 *
 * @author william
 */
public class MyServer   extends UnicastRemoteObject    implements MyRemoteInterface  
{
      public void printMessage(String message) throws RemoteException
      {
          System.out.println(message);
      }

      public  void run() throws Exception
      {
          MyServer server = new MyServer(); 
          Registry reg = LocateRegistry.createRegistry(1034);
          reg.bind("myrmiserver", server); 
      }

      public MyServer() throws RemoteException {}
}
