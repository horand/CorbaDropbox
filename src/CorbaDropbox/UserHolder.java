package CorbaDropbox;

/**
* CorbaDropbox/UserHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corbadropbox.idl
* 09 April 2013 15:56:25 o'clock IST
*/

public final class UserHolder implements org.omg.CORBA.portable.Streamable
{
  public CorbaDropbox.User value = null;

  public UserHolder ()
  {
  }

  public UserHolder (CorbaDropbox.User initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CorbaDropbox.UserHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CorbaDropbox.UserHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CorbaDropbox.UserHelper.type ();
  }

}
