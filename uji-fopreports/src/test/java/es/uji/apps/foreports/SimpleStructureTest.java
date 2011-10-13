package es.uji.apps.foreports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

import es.uji.apps.fopreports.fop.Block;
import es.uji.apps.fopreports.fop.Table;
import es.uji.apps.fopreports.fop.TableBody;
import es.uji.apps.fopreports.serialization.ReportSerializationException;
import es.uji.apps.fopreports.serialization.ReportSerializerInitException;

public class SimpleStructureTest
{
    private static final String BASE_DIR = "src/test/resources/";

    private SolicitudReport report;

    @Test
    public void generateSimpleStructure() throws ReportSerializerInitException,
            FileNotFoundException, ReportSerializationException
    {
        report = new SolicitudReport();

        report.withHeader();
        report.withFooter();

        buildSeccionDatosPersonales();
        buildSeccionRegistroCargosPublicos();

        report.serialize(new FileOutputStream(BASE_DIR + "generateSimpleStructure.pdf"));
    }

    private void buildSeccionDatosPersonales()
    {
        Block block = report.withNewBlock();
        block.getContent().add("1. DATOS PERSONALES");
        block.setColor("#a23d05");
        block.setFontSize("13pt");

        Table table = report.withNewTable();
        table.getBorderWidth().add("0.06cm");
        table.setSpaceBefore("0.3cm");
        table.withNewTableColumn().getColumnWidth().add("9cm");
        table.withNewTableColumn().getColumnWidth().add("9cm");

        TableBody tableBody = table.withNewTableBody();
        tableBody.getTableRow().add(report.withNewTableRow("Nombre y apellidos", "NIF"));
        tableBody.getTableRow().add(report.withNewTableRow("", ""));
        tableBody.getTableRow().add(report.withNewTableRow("Cargo", "Partido político"));
        tableBody.getTableRow().add(report.withNewTableRow("", ""));
        tableBody.getTableRow().add(
                report.withNewTableRow("Condición pensionista", "Localidad y provincia"));
        tableBody.getTableRow().add(report.withNewTableRow("", ""));
    }

    private void buildSeccionRegistroCargosPublicos()
    {
        Block block = report.withNewBlock();
        block.getContent().add("2. REGISTRO DE CARGOS PÚBLICOS");
        block.setColor("#a23d05");
        block.setFontSize("13pt");
        block.setSpaceBefore("0.5cm");

        Table table = report.withNewTable();
        table.getBorderWidth().add("0.06cm");
        table.setSpaceBefore("0.3cm");
        table.withNewTableColumn().getColumnWidth().add("4.5cm");
        table.withNewTableColumn().getColumnWidth().add("4.5cm");
        table.withNewTableColumn().getColumnWidth().add("4.5cm");
        table.withNewTableColumn().getColumnWidth().add("4.5cm");

        TableBody tableBody = table.withNewTableBody();
        tableBody.getTableRow().add(
                report.withNewTableRow("Entidad u organismo", "Cargo desempeñado",
                        "Fecha de nombramiento", "Entidad que lo propone"));
        tableBody.getTableRow().add(report.withNewTableRow("", "", "", ""));
    }

}