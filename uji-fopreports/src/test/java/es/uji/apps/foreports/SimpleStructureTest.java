package es.uji.apps.foreports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

import es.uji.apps.fopreports.fop.Block;
import es.uji.apps.fopreports.fop.DisplayAlignType;
import es.uji.apps.fopreports.fop.ExternalGraphic;
import es.uji.apps.fopreports.fop.Table;
import es.uji.apps.fopreports.fop.TableBody;
import es.uji.apps.fopreports.fop.TableCell;
import es.uji.apps.fopreports.fop.TableColumn;
import es.uji.apps.fopreports.fop.TableRow;
import es.uji.apps.fopreports.fop.TextAlignType;
import es.uji.apps.fopreports.serialization.ReportSerializationException;
import es.uji.apps.fopreports.serialization.ReportSerializerInitException;

public class SimpleStructureTest
{
    private static final String BASE_DIR = "src/test/resources/";

    @Test
    public void generateSimpleStructure() throws ReportSerializerInitException,
            FileNotFoundException, ReportSerializationException
    {
        Report report = new Report();

        report.setHeader(buildHeader());
        report.setFooter(buildFooter());

        Block block = new Block();
        block.setTextContent("1. DATOS PERSONALES");
        block.setColor("#a23d05");
        block.setFontSize("13pt");
        report.add(block);

        Table table = new Table();
        table.getBorderWidth().add("0.06cm");
        table.setSpaceBefore("0.3cm");

        TableColumn tableColumn = new TableColumn();
        tableColumn.getColumnWidth().add("9cm");
        table.getTableColumn().add(tableColumn);

        tableColumn = new TableColumn();
        tableColumn.getColumnWidth().add("9cm");
        table.getTableColumn().add(tableColumn);

        TableBody tableBody = new TableBody();

        tableBody.getTableRow().add(buildTableRow("Nombre y apellidos", "NIF"));
        tableBody.getTableRow().add(buildEmptyTableRow(2));
        tableBody.getTableRow().add(buildTableRow("Cargo", "Partido político"));
        tableBody.getTableRow().add(buildEmptyTableRow(2));
        tableBody.getTableRow()
                .add(buildTableRow("Condición pensionista", "Localidad y provincia"));
        tableBody.getTableRow().add(buildEmptyTableRow(2));

        table.getTableBody().add(tableBody);
        report.add(table);

        block = new Block();
        block.setTextContent("2. REGISTRO DE CARGOS PÚBLICOS");
        block.setColor("#a23d05");
        block.setFontSize("13pt");
        block.setSpaceBefore("0.5cm");
        report.add(block);

        table = new Table();
        table.getBorderWidth().add("0.06cm");
        table.setSpaceBefore("0.3cm");

        for (int i = 0; i < 4; i++)
        {
            tableColumn = new TableColumn();
            tableColumn.getColumnWidth().add("4.5cm");
            table.getTableColumn().add(tableColumn);
        }

        tableBody = new TableBody();

        tableBody.getTableRow().add(
                buildTableRow("Entidad u organismo", "Cargo desempeñado", "Fecha de nombramiento",
                        "Entidad que lo propone"));
        tableBody.getTableRow().add(buildEmptyTableRow(4));

        table.getTableBody().add(tableBody);
        report.add(table);

        report.serialize(new FileOutputStream(BASE_DIR + "generateSimpleStructure.pdf"));
    }

    private Block buildFooter()
    {
        Table table = new Table();
        table.getBorderWidth().add("0.06cm");

        TableColumn tableColumn = new TableColumn();
        tableColumn.getColumnWidth().add("8cm");
        table.getTableColumn().add(tableColumn);

        tableColumn = new TableColumn();
        tableColumn.getColumnWidth().add("2.5cm");
        table.getTableColumn().add(tableColumn);

        tableColumn = new TableColumn();
        tableColumn.getColumnWidth().add("2.5cm");
        table.getTableColumn().add(tableColumn);

        tableColumn = new TableColumn();
        tableColumn.getColumnWidth().add("5cm");
        table.getTableColumn().add(tableColumn);

        TableBody tableBody = new TableBody();

        TableRow tableRow = new TableRow();
        tableRow.getTableCell().add(buildCell("Castellón, 12 de Octubre de 2011", 3, 1));
        
        ExternalGraphic externalGraphic = new ExternalGraphic();
        externalGraphic
                .setSrc("/opt/devel/workspaces/uji/uji-fopreports/src/main/resources/logo.png");
        externalGraphic.setWidth("4.5cm");
        
        Block block = new Block();
        block.setTextAlign(TextAlignType.CENTER);
        block.getContent().add(externalGraphic);
        
        TableCell tableCell = new TableCell();
        tableCell.setBorder("solid");
        tableCell.setDisplayAlign(DisplayAlignType.CENTER);
        tableCell.getBorderColor().add("#a23d05");
        tableCell.setPadding("0.1cm");
        tableCell.getMarkerOrBlockOrBlockContainer().add(block);
        tableCell.setNumberRowsSpanned("6");
        
        tableRow.getTableCell().add(tableCell);
        tableBody.getTableRow().add(tableRow);

        tableRow = new TableRow();
        tableRow.getTableCell().add(buildCell("Número de registro: 12324", 1, 1));
        tableRow.getTableCell().add(buildCell("Fecha de registro: 01/01/2011", 2, 1));
        tableBody.getTableRow().add(tableRow);

        tableRow = new TableRow();
        tableRow.getTableCell().add(buildCell("Firmado por:", 2, 1));
        tableRow.getTableCell().add(buildCell("En fecha", 1, 1));
        tableBody.getTableRow().add(tableRow);

        tableRow = new TableRow();
        tableRow.getTableCell().add(buildEmptyCell(2, 1));
        tableRow.getTableCell().add(buildEmptyCell(1, 1));
        tableBody.getTableRow().add(tableRow);

        tableRow = new TableRow();
        tableRow.getTableCell().add(buildCell("Código de verificación: XXXXXXXXXX", 3, 1));
        tableBody.getTableRow().add(tableRow);

        tableRow = new TableRow();
        tableRow.getTableCell()
                .add(buildCell(
                        "Texto largo Texto largo Texto largo Texto largo Texto largo Texto largo Texto largo Texto largo Texto largo Texto largo Texto largo ",
                        3, 1));
        tableBody.getTableRow().add(tableRow);

        table.getTableBody().add(tableBody);

        Block result = new Block();
        result.getContent().add(table);

        return result;
    }

    private Block buildHeader()
    {
        ExternalGraphic externalGraphic = new ExternalGraphic();
        externalGraphic
                .setSrc("/opt/devel/workspaces/uji/uji-fopreports/src/main/resources/cabecera.png");
        externalGraphic.setWidth("18cm");

        Block block = new Block();
        block.setTextContent("REGISTRO DE INTERESES");
        block.setTextAlign(TextAlignType.END);
        block.setColor("#a23d05");

        Block result = new Block();
        result.getContent().add(externalGraphic);
        result.getContent().add(block);

        return result;
    }

    private TableRow buildTableRow(String... columnsText)
    {
        TableRow tableRow = new TableRow();

        for (String columnText : columnsText)
        {
            tableRow.getTableCell().add(buildCell(columnText, 1, 1));
        }

        return tableRow;
    }

    private TableRow buildEmptyTableRow(int numColumns)
    {
        TableRow tableRow = new TableRow();

        for (int i = 0; i < numColumns; i++)
        {
            tableRow.getTableCell().add(buildEmptyCell(1, 1));
        }

        return tableRow;
    }

    private TableCell buildCell(String leftCellText, int colSpan, int rowSpan)
    {
        TableCell tableCell = new TableCell();
        tableCell.setBorder("solid");
        tableCell.setDisplayAlign(DisplayAlignType.BEFORE);
        tableCell.getBorderColor().add("#a23d05");
        tableCell.setPadding("0.1cm");
        tableCell.setNumberColumnsSpanned(String.valueOf(colSpan));
        tableCell.setNumberRowsSpanned(String.valueOf(rowSpan));

        Block block = new Block();
        block.setTextContent(leftCellText);
        block.setColor("#a23d05");
        block.setFontSize("7pt");
        tableCell.getMarkerOrBlockOrBlockContainer().add(block);

        return tableCell;
    }

    private TableCell buildEmptyCell(int colSpan, int rowSpan)
    {
        TableCell tableCell = new TableCell();
        tableCell.setBorder("solid");
        tableCell.setDisplayAlign(DisplayAlignType.BEFORE);
        tableCell.getBorderColor().add("#a23d05");
        tableCell.setPadding("0.1cm");
        tableCell.setHeight("0.8cm");
        tableCell.setNumberColumnsSpanned(String.valueOf(colSpan));
        tableCell.setNumberRowsSpanned(String.valueOf(rowSpan));
        tableCell.getMarkerOrBlockOrBlockContainer().add(new Block());

        return tableCell;
    }
}