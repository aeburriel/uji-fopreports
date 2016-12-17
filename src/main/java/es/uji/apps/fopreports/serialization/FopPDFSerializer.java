package es.uji.apps.fopreports.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import es.uji.apps.fopreports.fop.Root;

public class FopPDFSerializer implements ReportSerializer
{
    private Marshaller marshaller;
    private Transformer transformer;
    private JAXBContext context;

    public FopPDFSerializer() throws ReportSerializerInitException
    {
        try
        {
            context = JAXBContext.newInstance(Root.class);

            TransformerFactory factory = TransformerFactory.newInstance();
            transformer = factory.newTransformer();
        }
        catch (Exception e)
        {
            throw new ReportSerializerInitException(e);
        }
    }

    @Override
    public void serialize(Root root, OutputStream output) throws ReportSerializationException
    {
        try {
        	FopFactory fopFactory = FopFactory.newInstance(new File("/etc/uji/fop.xconf"));
        	serialize(root, output, fopFactory);
        } catch (Exception e) {
            throw new ReportSerializationException(e);
        }
    }

	@Override
	public void serialize(Root root, OutputStream output, FopFactory fopFactory)
			throws ReportSerializationException {
		try
        {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    marshaller = context.createMarshaller();
            marshaller.marshal(root, bos);
            
            System.out.println(new String(bos.toByteArray()));

            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, output);

            Source source = new StreamSource(new ByteArrayInputStream(bos.toByteArray()));
            Result result = new SAXResult(fop.getDefaultHandler());

            transformer.transform(source, result);
        }
        catch (Exception e)
        {
            throw new ReportSerializationException(e);
        }
	}
}
