package CorbaDropbox;


/**
* CorbaDropbox/DocServiceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corbadropbox.idl
* 09 April 2013 15:56:25 o'clock IST
*/

abstract public class DocServiceHelper
{
  private static String  _id = "IDL:CorbaDropbox/DocService:1.0";

  public static void insert (org.omg.CORBA.Any a, CorbaDropbox.DocService that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CorbaDropbox.DocService extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CorbaDropbox.DocServiceHelper.id (), "DocService");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CorbaDropbox.DocService read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_DocServiceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CorbaDropbox.DocService value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CorbaDropbox.DocService narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CorbaDropbox.DocService)
      return (CorbaDropbox.DocService)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CorbaDropbox._DocServiceStub stub = new CorbaDropbox._DocServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CorbaDropbox.DocService unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CorbaDropbox.DocService)
      return (CorbaDropbox.DocService)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CorbaDropbox._DocServiceStub stub = new CorbaDropbox._DocServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
