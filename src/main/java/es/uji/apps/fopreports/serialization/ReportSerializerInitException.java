package es.uji.apps.fopreports.serialization;

@SuppressWarnings("serial")
public class ReportSerializerInitException extends Exception
{
    public ReportSerializerInitException(Exception e)
    {
        super(e);
    }
}
