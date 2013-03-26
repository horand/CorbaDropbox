package CorbaDropbox;


/**
* CorbaDropbox/UserServicePOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CorbaDropbox.idl
* Tuesday, March 26, 2013 8:14:52 PM GMT
*/

public class UserServicePOATie extends UserServicePOA
{

  // Constructors

  public UserServicePOATie ( CorbaDropbox.UserServiceOperations delegate ) {
      this._impl = delegate;
  }
  public UserServicePOATie ( CorbaDropbox.UserServiceOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public CorbaDropbox.UserServiceOperations _delegate() {
      return this._impl;
  }
  public void _delegate (CorbaDropbox.UserServiceOperations delegate ) {
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
  public boolean register (String username, String password)
  {
    return _impl.register(username, password);
  } // register

  public CorbaDropbox.User login (String username, String password)
  {
    return _impl.login(username, password);
  } // login

  public String doclist (CorbaDropbox.User user)
  {
    return _impl.doclist(user);
  } // doclist

  private CorbaDropbox.UserServiceOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class UserServicePOATie