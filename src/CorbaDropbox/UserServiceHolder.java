package CorbaDropbox;

/**
* CorbaDropbox/UserServiceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corbadropbox.idl
* 09 April 2013 15:56:25 o'clock IST
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
