package es.uji.apps.fopreports.serialization;

import java.io.OutputStream;

import org.apache.fop.apps.FopFactory;

import es.uji.apps.fopreports.fop.Root;

public interface ReportSerializer
{
    public void serialize(Root root, OutputStream output) throws ReportSerializationException;
    public void serialize(Root root, OutputStream output, FopFactory fopFactory) throws ReportSerializationException;
}
