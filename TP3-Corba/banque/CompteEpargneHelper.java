package banque;
/**
* CompteEpargneHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from banque.idl
* jeudi 26 septembre 2024 16 h 35 CEST
*/

abstract public class CompteEpargneHelper
{
  private static String  _id = "IDL:CompteEpargne:1.0";

  public static void insert (org.omg.CORBA.Any a, CompteEpargne that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CompteEpargne extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CompteEpargneHelper.id (), "CompteEpargne");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CompteEpargne read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_CompteEpargneStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CompteEpargne value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CompteEpargne narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CompteEpargne)
      return (CompteEpargne)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _CompteEpargneStub stub = new _CompteEpargneStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CompteEpargne unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CompteEpargne)
      return (CompteEpargne)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _CompteEpargneStub stub = new _CompteEpargneStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
