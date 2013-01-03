package es.uji.apps.fopreports.serialization;

import java.io.OutputStream;

import es.uji.apps.fopreports.fop.Root;

public interface ReportSerializer
{
    public void serialize(Root root, OutputStream output) throws ReportSerializationException;
}
