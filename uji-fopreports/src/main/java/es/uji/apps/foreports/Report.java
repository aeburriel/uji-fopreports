package es.uji.apps.foreports;

import java.io.OutputStream;

import es.uji.apps.fopreports.fop.Block;
import es.uji.apps.fopreports.fop.DisplayAlignType;
import es.uji.apps.fopreports.fop.PageSequence;
import es.uji.apps.fopreports.fop.Root;
import es.uji.apps.fopreports.fop.SimplePageMaster;
import es.uji.apps.fopreports.fop.StaticContent;
import es.uji.apps.fopreports.fop.Table;
import es.uji.apps.fopreports.fop.TableCell;
import es.uji.apps.fopreports.fop.TableRow;
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
        simplePageMaster.withRegionBefore().setExtent("3cm");
        simplePageMaster.withRegionAfter().setExtent("5cm");
        simplePageMaster.withRegionBody().setMarginTop("3cm");
        simplePageMaster.withRegionBody().setMarginBottom("2cm");

        root = new Root();
        root.withLayoutMasterSet().getSimplePageMasterOrPageSequenceMaster().add(simplePageMaster);
        PageSequence pageSequence = root.withNewPageSequence();
        pageSequence.setMasterReference("first");
        pageSequence.withFlow().setFlowName("xsl-region-body");
    }

    protected void add(Object content)
    {
        root.withPageSequence(0).withFlow().getMarkerOrBlockOrBlockContainer().add(content);
    }

    protected void serialize(OutputStream output) throws ReportSerializationException
    {
        serializer.serialize(root, output);
    }

    protected Block withNewBlock()
    {
        Block block = new Block();
        add(block);
        
        return block;
    }
    
    protected Table withNewTable()
    {
        Table table = new Table();
        add(table);
        
        return table;
    }
    
    protected Block withHeader()
    {
        Block block = new Block();
        StaticContent staticContent = root.withPageSequence(0).withNewStaticContent();
        staticContent.setFlowName("xsl-region-before");
        staticContent.getBlockOrBlockContainerOrTable().add(block);
        
        return block;
    }

    protected Block withFooter()
    {
        Block block = new Block();
        StaticContent staticContent = root.withPageSequence(0).withNewStaticContent();
        staticContent.setFlowName("xsl-region-after");
        staticContent.getBlockOrBlockContainerOrTable().add(block);
        
        return block;
    }
    
    protected TableCell withNewCell(int colSpan, int rowSpan)
    {
        TableCell tableCell = new TableCell();
        tableCell.setBorder("solid");
        tableCell.setDisplayAlign(DisplayAlignType.BEFORE);
        tableCell.setPadding("0.1cm");
        tableCell.setNumberColumnsSpanned(String.valueOf(colSpan));
        tableCell.setNumberRowsSpanned(String.valueOf(rowSpan));

        return tableCell;
    }

    protected TableCell withNewTextCell(String cellText, int colSpan, int rowSpan)
    {
        TableCell tableCell = withNewCell(colSpan, rowSpan);

        Block block = new Block();
        block.getContent().add(cellText);
        block.setFontSize("7pt");
        tableCell.getMarkerOrBlockOrBlockContainer().add(block);

        return tableCell;
    }

    protected TableCell withNewEmptyCell(int colSpan, int rowSpan)
    {
        TableCell tableCell = withNewCell(colSpan, rowSpan);

        tableCell.getMarkerOrBlockOrBlockContainer().add(new Block());

        return tableCell;
    }
    
    protected TableRow withNewTableRow(String... columnsText)
    {
        TableRow tableRow = new TableRow();

        for (String columnText : columnsText)
        {
            tableRow.getTableCell().add(withNewTextCell(columnText, 1, 1));
        }

        return tableRow;
    }
}