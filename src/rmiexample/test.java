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
public class test
{
      public static void main(String [] args) throws Exception  
      {
          MyClient thread1 = new MyClient();
          thread1.start() ;
          MyServer c = new MyServer();
          c.run();
      }
    
}
