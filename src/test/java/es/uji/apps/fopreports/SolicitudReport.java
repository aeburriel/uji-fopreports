package es.uji.apps.fopreports;

import es.uji.apps.fopreports.Report;
import es.uji.apps.fopreports.fop.Block;
import es.uji.apps.fopreports.fop.ExternalGraphic;
import es.uji.apps.fopreports.fop.Table;
import es.uji.apps.fopreports.fop.TableBody;
import es.uji.apps.fopreports.fop.TableCell;
import es.uji.apps.fopreports.fop.TableRow;
import es.uji.apps.fopreports.fop.TextAlignType;
import es.uji.apps.fopreports.serialization.ReportSerializer;
import es.uji.apps.fopreports.serialization.ReportSerializerInitException;
import es.uji.apps.fopreports.style.ReportStyle;

public class SolicitudReport extends Report
{
    private final ReportStyle style;

    public SolicitudReport(ReportSerializer serializer, ReportStyle style)
            throws ReportSerializerInitException
    {
        super(serializer, style);

        getSimplePageMaster().getRegionBody().setBackgroundImage("/opt/devel/workspaces/uji/uji-fopreports/src/main/resources/fondo.jpg");


        this.style = style;
    }

    @Override
    public Block withHeader()
    {
        Block result = super.withHeader();

        ExternalGraphic externalGraphic = new ExternalGraphic();
        externalGraphic
                .setSrc("/opt/devel/workspaces/uji/uji-fopreports/src/main/resources/cabecera.png");
        externalGraphic.setWidth("18cm");

        Block block = new Block(style);
        block.getContent().add("REGISTRO DE INTERESES");
        block.setTextAlign(TextAlignType.END);

        result.getContent().add(externalGraphic);
        result.getContent().add(block);

        return result;
    }

    @Override
    public Block withFooter()
    {
        Block result = super.withFooter();

        Table table = new Table();
        table.getBorderWidth().add("0.06cm");
        table.withNewTableColumn().getColumnWidth().add("8cm");
        table.withNewTableColumn().getColumnWidth().add("2.5cm");
        table.withNewTableColumn().getColumnWidth().add("2.5cm");
        table.withNewTableColumn().getColumnWidth().add("5cm");

        TableBody tableBody = table.withNewTableBody();

        TableRow tableRow = tableBody.withNewTableRow();
        tableRow.getTableCell().add(withNewTextCell("Castellón, 12 de Octubre de 2011", 3, 1));

        ExternalGraphic externalGraphic = new ExternalGraphic();
        externalGraphic
                .setSrc("/opt/devel/workspaces/uji/uji-fopreports/src/main/resources/logo.png");
        externalGraphic.setWidth("4.5cm");

        Block block = new Block();
        block.setTextAlign(TextAlignType.CENTER);
        block.getContent().add(externalGraphic);

        TableCell tableCell = withNewCell(1, 6);
        tableCell.getMarkerOrBlockOrBlockContainer().add(block);
        tableRow.getTableCell().add(tableCell);

        tableRow = tableBody.withNewTableRow();
        tableRow.getTableCell().add(withNewTextCell("Número de registro: 12324", 1, 1));
        tableRow.getTableCell().add(withNewTextCell("Fecha de registro: 01/01/2011", 2, 1));

        tableRow = tableBody.withNewTableRow();
        tableRow.getTableCell().add(withNewTextCell("Firmado por:", 2, 1));
        tableRow.getTableCell().add(withNewTextCell("En fecha", 1, 1));

        tableRow = tableBody.withNewTableRow();
        tableRow.getTableCell().add(withNewEmptyCell(2, 1));
        tableRow.getTableCell().add(withNewEmptyCell(1, 1));

        tableBody.withNewTableRow().getTableCell()
                .add(withNewTextCell("Código de verificación: XXXXXXXXXX", 3, 1));

        String longText = "Texto largo Texto largo Texto largo Texto largo "
                + "Texto largo Texto largo Texto largo Texto largo "
                + "Texto largo Texto largo Texto largo ";

        tableBody.withNewTableRow().getTableCell().add(withNewTextCell(longText, 3, 1));

        result.getContent().add(table);

        return result;
    }
}