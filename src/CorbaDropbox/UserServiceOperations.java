package CorbaDropbox;


/**
* CorbaDropbox/UserServiceOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CorbaDropbox.idl
* Saturday, March 23, 2013 2:07:48 PM GMT
*/

public interface UserServiceOperations 
{
  boolean register (String username, String password);
  CorbaDropbox.User login (String username, String password);
  String doclist (CorbaDropbox.User user);
} // interface UserServiceOperations
