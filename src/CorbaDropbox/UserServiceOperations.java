package CorbaDropbox;


/**
* CorbaDropbox/UserServiceOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corbadropbox.idl
* 09 April 2013 15:56:25 o'clock IST
*/

public interface UserServiceOperations 
{
  boolean register (String username, String password);
  CorbaDropbox.User login (String username, String password);
} // interface UserServiceOperations
