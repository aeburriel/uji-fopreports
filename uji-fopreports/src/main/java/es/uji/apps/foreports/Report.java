package es.uji.apps.foreports;

import java.io.OutputStream;

import es.uji.apps.fopreports.fop.Block;
import es.uji.apps.fopreports.fop.Flow;
import es.uji.apps.fopreports.fop.LayoutMasterSet;
import es.uji.apps.fopreports.fop.PageSequence;
import es.uji.apps.fopreports.fop.RegionAfter;
import es.uji.apps.fopreports.fop.RegionBefore;
import es.uji.apps.fopreports.fop.RegionBody;
import es.uji.apps.fopreports.fop.Root;
import es.uji.apps.fopreports.fop.SimplePageMaster;
import es.uji.apps.fopreports.fop.StaticContent;
import es.uji.apps.fopreports.serialization.FopPDFSerializer;
import es.uji.apps.fopreports.serialization.ReportSerializationException;
import es.uji.apps.fopreports.serialization.ReportSerializer;
import es.uji.apps.fopreports.serialization.ReportSerializerInitException;

public class Report
{
    private ReportSerializer serializer;

    private Root root;

    public Report() throws ReportSerializerInitException
    {
        serializer = new FopPDFSerializer();

        SimplePageMaster simplePageMaster = new SimplePageMaster();
        simplePageMaster.setMarginRight("2.5cm");
        simplePageMaster.setMarginLeft("1.5cm");
        simplePageMaster.setMarginBottom("1cm");
        simplePageMaster.setMarginTop("1cm");
        simplePageMaster.setPageWidth("21cm");
        simplePageMaster.setPageHeight("29.70cm");
        simplePageMaster.setMasterName("first");

        RegionBefore regionBefore = new RegionBefore();
        regionBefore.setExtent("3cm");
        simplePageMaster.setRegionBefore(regionBefore);

        RegionBody regionBody = new RegionBody();
        regionBody.setMarginTop("3cm");
        regionBody.setMarginBottom("2cm");
        simplePageMaster.setRegionBody(regionBody);

        RegionAfter regionAfter = new RegionAfter();
        regionAfter.setExtent("5cm");
        simplePageMaster.setRegionAfter(regionAfter);

        LayoutMasterSet layoutMaster = new LayoutMasterSet();
        layoutMaster.getSimplePageMasterOrPageSequenceMaster().add(simplePageMaster);

        Flow flow = new Flow();
        flow.setFlowName("xsl-region-body");

        PageSequence pageSequence = new PageSequence();
        pageSequence.setMasterReference("first");
        pageSequence.setFlow(flow);        

        root = new Root();
        root.setLayoutMasterSet(layoutMaster);
        root.getPageSequence().add(pageSequence);
    }

    public void add(Object content)
    {
        root.getPageSequence().get(0).getFlow().getElements().add(content);
    }

    public void serialize(OutputStream output) throws ReportSerializationException
    {
        serializer.serialize(root, output);
    }
    
    public void setHeader(Block block)
    {
        StaticContent staticContent = new StaticContent();
        staticContent.setFlowName("xsl-region-before");
        staticContent.getBlockOrBlockContainerOrTable().add(block);
        
        root.getPageSequence().get(0).getStaticContent().add(staticContent);        
    }
    
    public void setFooter(Block block)
    {
        StaticContent staticContent = new StaticContent();
        staticContent.setFlowName("xsl-region-after");
        staticContent.getBlockOrBlockContainerOrTable().add(block);
        
        root.getPageSequence().get(0).getStaticContent().add(staticContent);        
    }    
}