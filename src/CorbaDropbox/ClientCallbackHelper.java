package CorbaDropbox;


/**
* CorbaDropbox/ClientCallbackHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CorbaDropbox.idl
* Tuesday, March 26, 2013 8:14:52 PM GMT
*/

abstract public class ClientCallbackHelper
{
  private static String  _id = "IDL:CorbaDropbox/ClientCallback:1.0";

  public static void insert (org.omg.CORBA.Any a, CorbaDropbox.ClientCallback that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CorbaDropbox.ClientCallback extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CorbaDropbox.ClientCallbackHelper.id (), "ClientCallback");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CorbaDropbox.ClientCallback read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ClientCallbackStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CorbaDropbox.ClientCallback value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CorbaDropbox.ClientCallback narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CorbaDropbox.ClientCallback)
      return (CorbaDropbox.ClientCallback)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CorbaDropbox._ClientCallbackStub stub = new CorbaDropbox._ClientCallbackStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CorbaDropbox.ClientCallback unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CorbaDropbox.ClientCallback)
      return (CorbaDropbox.ClientCallback)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CorbaDropbox._ClientCallbackStub stub = new CorbaDropbox._ClientCallbackStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}