package CorbaDropbox;


/**
* CorbaDropbox/UserServicePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
<<<<<<< HEAD
* from ../corbadropbox.idl
* 06 April 2013 13:35:47 o'clock IST
=======
* from CorbaDropbox.idl
* Saturday, April 6, 2013 12:32:38 PM IST
>>>>>>> not a clue
*/

public abstract class UserServicePOA extends org.omg.PortableServer.Servant
 implements CorbaDropbox.UserServiceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("register", new java.lang.Integer (0));
    _methods.put ("login", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CorbaDropbox/UserService/register
       {
         String username = in.read_string ();
         String password = in.read_string ();
         boolean $result = false;
         $result = this.register (username, password);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // CorbaDropbox/UserService/login
       {
         String username = in.read_string ();
         String password = in.read_string ();
         CorbaDropbox.User $result = null;
         $result = this.login (username, password);
         out = $rh.createReply();
         CorbaDropbox.UserHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CorbaDropbox/UserService:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public UserService _this() 
  {
    return UserServiceHelper.narrow(
    super._this_object());
  }

  public UserService _this(org.omg.CORBA.ORB orb) 
  {
    return UserServiceHelper.narrow(
    super._this_object(orb));
  }


} // class UserServicePOA
