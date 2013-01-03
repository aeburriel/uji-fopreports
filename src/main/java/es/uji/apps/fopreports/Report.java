package es.uji.apps.fopreports;

import java.io.OutputStream;

import es.uji.apps.fopreports.fop.Block;
import es.uji.apps.fopreports.fop.PageSequence;
import es.uji.apps.fopreports.fop.Root;
import es.uji.apps.fopreports.fop.StaticContent;
import es.uji.apps.fopreports.fop.Table;
import es.uji.apps.fopreports.fop.TableCell;
import es.uji.apps.fopreports.fop.TableRow;
import es.uji.apps.fopreports.serialization.ReportSerializationException;
import es.uji.apps.fopreports.serialization.ReportSerializer;
import es.uji.apps.fopreports.serialization.ReportSerializerInitException;
import es.uji.apps.fopreports.style.ReportStyle;

public class Report
{
    private ReportSerializer serializer;
    private ReportStyle style;

    private Root root;

    public Report(ReportSerializer serializer, ReportStyle style)
            throws ReportSerializerInitException
    {
        this.serializer = serializer;
        this.style = style;

        root = new Root(style);
        root.withLayoutMasterSet().addSimplePageMaster().setMasterName("first");

        PageSequence pageSequence = root.withNewPageSequence();
        pageSequence.setMasterReference("first");
        pageSequence.withFlow().setFlowName("xsl-region-body");
    }

    protected void add(Object content)
    {
        root.withPageSequence(0).withFlow().getMarkerOrBlockOrBlockContainer().add(content);
    }

    public void serialize(OutputStream output) throws ReportSerializationException
    {
        serializer.serialize(root, output);
    }

    public Block withNewBlock()
    {
        Block block = new Block(style);
        add(block);

        return block;
    }

    protected Table withNewTable()
    {
        Table table = new Table(style);
        add(table);

        return table;
    }

    protected Block withHeader()
    {
        Block block = new Block(style);
        StaticContent staticContent = root.withPageSequence(0).withNewStaticContent();
        staticContent.setFlowName("xsl-region-before");
        staticContent.getBlockOrBlockContainerOrTable().add(block);

        return block;
    }

    protected Block withFooter()
    {
        Block block = new Block(style);
        StaticContent staticContent = root.withPageSequence(0).withNewStaticContent();
        staticContent.setFlowName("xsl-region-after");
        staticContent.getBlockOrBlockContainerOrTable().add(block);

        return block;
    }

    protected TableCell withNewCell(int colSpan, int rowSpan)
    {
        TableCell tableCell = new TableCell(style);
        tableCell.setNumberColumnsSpanned(String.valueOf(colSpan));
        tableCell.setNumberRowsSpanned(String.valueOf(rowSpan));

        return tableCell;
    }

    protected TableCell withNewTextCell(String cellText, int colSpan, int rowSpan)
    {
        TableCell tableCell = withNewCell(colSpan, rowSpan);

        Block block = new Block(style);
        block.getContent().add(cellText);
        tableCell.getMarkerOrBlockOrBlockContainer().add(block);

        return tableCell;
    }

    protected TableCell withNewEmptyCell(int colSpan, int rowSpan)
    {
        TableCell tableCell = withNewCell(colSpan, rowSpan);

        tableCell.getMarkerOrBlockOrBlockContainer().add(new Block(style));

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
