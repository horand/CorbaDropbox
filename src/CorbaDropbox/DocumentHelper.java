package CorbaDropbox;


/**
* CorbaDropbox/DocumentHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corbadropbox.idl
* 06 April 2013 13:35:47 o'clock IST
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
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [4];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "filename",
            _tcOf_members0,
            null);
          _tcOf_members0 = CorbaDropbox.UserHelper.type ();
          _members0[1] = new org.omg.CORBA.StructMember (
            "user",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "contents",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_boolean);
          _members0[3] = new org.omg.CORBA.StructMember (
            "isPrivate",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (CorbaDropbox.DocumentHelper.id (), "Document", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CorbaDropbox.Document read (org.omg.CORBA.portable.InputStream istream)
  {
    CorbaDropbox.Document value = new CorbaDropbox.Document ();
    value.filename = istream.read_string ();
    value.user = CorbaDropbox.UserHelper.read (istream);
    value.contents = istream.read_string ();
    value.isPrivate = istream.read_boolean ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CorbaDropbox.Document value)
  {
    ostream.write_string (value.filename);
    CorbaDropbox.UserHelper.write (ostream, value.user);
    ostream.write_string (value.contents);
    ostream.write_boolean (value.isPrivate);
  }

}
