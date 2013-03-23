package CorbaDropbox;


/**
* CorbaDropbox/DocumentHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CorbaDropbox.idl
* Saturday, March 23, 2013 2:07:48 PM GMT
*/

abstract public class DocumentHelper
{
  private static String  _id = "IDL:CorbaDropbox/Document:1.0";

  public static void insert (org.omg.CORBA.Any a, CorbaDropbox.Document that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CorbaDropbox.Document extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CorbaDropbox.DocumentHelper.id (), "Document");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CorbaDropbox.Document read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_DocumentStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CorbaDropbox.Document value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CorbaDropbox.Document narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CorbaDropbox.Document)
      return (CorbaDropbox.Document)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CorbaDropbox._DocumentStub stub = new CorbaDropbox._DocumentStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CorbaDropbox.Document unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CorbaDropbox.Document)
      return (CorbaDropbox.Document)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CorbaDropbox._DocumentStub stub = new CorbaDropbox._DocumentStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
