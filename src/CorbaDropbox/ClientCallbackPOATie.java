package CorbaDropbox;


/**
* CorbaDropbox/ClientCallbackPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CorbaDropbox.idl
* Tuesday, April 2, 2013 7:19:17 PM IST
*/

public class ClientCallbackPOATie extends ClientCallbackPOA
{

  // Constructors

  public ClientCallbackPOATie ( CorbaDropbox.ClientCallbackOperations delegate ) {
      this._impl = delegate;
  }
  public ClientCallbackPOATie ( CorbaDropbox.ClientCallbackOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public CorbaDropbox.ClientCallbackOperations _delegate() {
      return this._impl;
  }
  public void _delegate (CorbaDropbox.ClientCallbackOperations delegate ) {
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
  public void doCallback (String msg)
  {
    _impl.doCallback(msg);
  } // doCallback

  private CorbaDropbox.ClientCallbackOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class ClientCallbackPOATie
