package CorbaDropbox;


/**
* CorbaDropbox/UserOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CorbaDropbox.idl
* Saturday, March 23, 2013 2:07:48 PM GMT
*/

public interface UserOperations 
{
  String username ();
  void username (String newUsername);
  String password ();
  void password (String newPassword);
  boolean isLoggedIn ();
  void isLoggedIn (boolean newIsLoggedIn);
} // interface UserOperations
