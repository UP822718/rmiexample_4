/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiexample;

/**
 *
 * @author william
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
  import java.rmi.registry.*;
import java.util.logging.Level;
import java.util.logging.Logger;

  public class MyClient extends Thread
  {
      public  void run()   
      {
                  System.err.println("test1");
          Registry reg = null;
          MyRemoteInterface handle = null;
          boolean error = true;
          while(error)
          {
              try
              {
                    Thread.currentThread().sleep(30*1000) ;  // 30 seconds
                    System.out.println("attempting connection") ;
                  reg = LocateRegistry.getRegistry("localhost", 1034) ;
                  handle =(MyRemoteInterface) reg.lookup("myrmiserver");
                  error = false;
                  System.err.println("test1");
              }
              catch(Exception e)
              {
                   
                  System.err.println("test2");       
              }
          }
          BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
          while(true)
          {
            String message = null ;
                try {
                          message = in.readLine();
                      } catch (IOException ex) {
                          Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      try {
                          handle.printMessage(message);
                      } catch (RemoteException ex) {
                          Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
                      }
          }
      }
  }
