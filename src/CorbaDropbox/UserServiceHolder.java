package CorbaDropbox;

/**
* CorbaDropbox/UserServiceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
<<<<<<< HEAD
* from ../corbadropbox.idl
* 06 April 2013 13:35:47 o'clock IST
=======
* from CorbaDropbox.idl
* Saturday, April 6, 2013 12:32:38 PM IST
>>>>>>> not a clue
*/

public final class UserServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public CorbaDropbox.UserService value = null;

  public UserServiceHolder ()
  {
  }

  public UserServiceHolder (CorbaDropbox.UserService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CorbaDropbox.UserServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CorbaDropbox.UserServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CorbaDropbox.UserServiceHelper.type ();
  }

}
