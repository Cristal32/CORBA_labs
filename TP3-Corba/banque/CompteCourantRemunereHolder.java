package banque;
/**
* CompteCourantRemunereHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from banque.idl
* jeudi 26 septembre 2024 16 h 35 CEST
*/

public final class CompteCourantRemunereHolder implements org.omg.CORBA.portable.Streamable
{
  public CompteCourantRemunere value = null;

  public CompteCourantRemunereHolder ()
  {
  }

  public CompteCourantRemunereHolder (CompteCourantRemunere initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CompteCourantRemunereHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CompteCourantRemunereHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CompteCourantRemunereHelper.type ();
  }

}
