package CorbaDropbox;


/**
* CorbaDropbox/Document.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corbadropbox.idl
* 09 April 2013 15:56:25 o'clock IST
*/

public final class Document implements org.omg.CORBA.portable.IDLEntity
{
  public String filename = null;
  public CorbaDropbox.User user = null;
  public String contents = null;
  public boolean isPrivate = false;

  public Document ()
  {
  } // ctor

  public Document (String _filename, CorbaDropbox.User _user, String _contents, boolean _isPrivate)
  {
    filename = _filename;
    user = _user;
    contents = _contents;
    isPrivate = _isPrivate;
  } // ctor

} // class Document
