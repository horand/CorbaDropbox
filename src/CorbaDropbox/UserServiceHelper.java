package CorbaDropbox;


/**
* CorbaDropbox/UserServiceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CorbaDropbox.idl
* Tuesday, April 2, 2013 7:19:17 PM IST
*/

abstract public class UserServiceHelper
{
  private static String  _id = "IDL:CorbaDropbox/UserService:1.0";

  public static void insert (org.omg.CORBA.Any a, CorbaDropbox.UserService that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CorbaDropbox.UserService extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CorbaDropbox.UserServiceHelper.id (), "UserService");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CorbaDropbox.UserService read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_UserServiceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CorbaDropbox.UserService value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CorbaDropbox.UserService narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CorbaDropbox.UserService)
      return (CorbaDropbox.UserService)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CorbaDropbox._UserServiceStub stub = new CorbaDropbox._UserServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CorbaDropbox.UserService unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CorbaDropbox.UserService)
      return (CorbaDropbox.UserService)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CorbaDropbox._UserServiceStub stub = new CorbaDropbox._UserServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
