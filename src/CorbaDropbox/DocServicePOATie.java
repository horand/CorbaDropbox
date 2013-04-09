package CorbaDropbox;


/**
* CorbaDropbox/DocServicePOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corbadropbox.idl
* 09 April 2013 15:56:25 o'clock IST
*/

public class DocServicePOATie extends DocServicePOA
{

  // Constructors

  public DocServicePOATie ( CorbaDropbox.DocServiceOperations delegate ) {
      this._impl = delegate;
  }
  public DocServicePOATie ( CorbaDropbox.DocServiceOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public CorbaDropbox.DocServiceOperations _delegate() {
      return this._impl;
  }
  public void _delegate (CorbaDropbox.DocServiceOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public boolean uploadDoc (CorbaDropbox.Document document)
  {
    return _impl.uploadDoc(document);
  } // uploadDoc

  public CorbaDropbox.Document downloadDoc (String filename, CorbaDropbox.User user)
  {
    return _impl.downloadDoc(filename, user);
  } // downloadDoc

  public boolean queryDocuments (String filename, CorbaDropbox.User user)
  {
    return _impl.queryDocuments(filename, user);
  } // queryDocuments

  public String[] listDocuments ()
  {
    return _impl.listDocuments();
  } // listDocuments

  public String[] listUserDocuments (CorbaDropbox.User user)
  {
    return _impl.listUserDocuments(user);
  } // listUserDocuments

  public boolean updateDoc (CorbaDropbox.Document document)
  {
    return _impl.updateDoc(document);
  } // updateDoc

  private CorbaDropbox.DocServiceOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class DocServicePOATie
