package CorbaDropbox;


/**
* CorbaDropbox/User.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corbadropbox.idl
* 08 April 2013 15:43:08 o'clock IST
*/

public final class User implements org.omg.CORBA.portable.IDLEntity
{
  public String username = null;
  public String password = null;
  public boolean isLoggedIn = false;

  public User ()
  {
  } // ctor

  public User (String _username, String _password, boolean _isLoggedIn)
  {
    username = _username;
    password = _password;
    isLoggedIn = _isLoggedIn;
  } // ctor

} // class User
