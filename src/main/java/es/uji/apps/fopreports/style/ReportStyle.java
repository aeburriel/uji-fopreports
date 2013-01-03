package es.uji.apps.fopreports.style;

import es.uji.apps.fopreports.fop.DisplayAlignType;
import es.uji.apps.fopreports.fop.TextAlignType;

public class ReportStyle
{
    private String simplePageMasterMarginRight;
    private String simplePageMasterMarginLeft;
    private String simplePageMasterMarginBottom;
    private String simplePageMasterMarginTop;
    private String simplePageMasterPageWidth;
    private String simplePageMasterPageHeight;
    private String simplePageMasterRegionBeforeExtent;
    private String simplePageMasterRegionAfterExtent;
    private String simplePageMasterRegionBodyMarginTop;
    private String simplePageMasterRegionBodyMarginBottom;
    
    private String tableCellPadding;
    private String tableCellBorder;
    private String tableCellFontSize;
    private String tableCellColor;
    private String tableCellBorderColor;
    private DisplayAlignType tableCellDisplayAlign;
    
    private String blockFontSize;
    private TextAlignType blockTextAlign;
    private String blockColor;
    
    public ReportStyle()
    {
        simplePageMasterMarginRight = "2.5cm";
        simplePageMasterMarginLeft = "1.5cm";
        simplePageMasterMarginBottom = "1cm";
        simplePageMasterMarginTop = "1cm";
        simplePageMasterPageWidth = "21cm";
        simplePageMasterPageHeight = "29.70cm";
        simplePageMasterRegionBeforeExtent = "3cm";
        simplePageMasterRegionAfterExtent = "5cm";
        simplePageMasterRegionBodyMarginTop = "3cm";
        simplePageMasterRegionBodyMarginBottom = "2cm";
        
        tableCellPadding = "0.1cm";
        tableCellBorder = "solid";
        tableCellFontSize = "7pt";
        tableCellColor = "#000000";
        tableCellBorderColor = "#000000";
        tableCellDisplayAlign = DisplayAlignType.BEFORE;
        
        blockFontSize = "7pt";
        blockTextAlign = TextAlignType.START;
        blockColor = "#000000";
    }

    public String getSimplePageMasterMarginRight()
    {
        return simplePageMasterMarginRight;
    }

    public void setSimplePageMasterMarginRight(String simplePageMasterMarginRight)
    {
        this.simplePageMasterMarginRight = simplePageMasterMarginRight;
    }

    public String getSimplePageMasterMarginLeft()
    {
        return simplePageMasterMarginLeft;
    }

    public void setSimplePageMasterMarginLeft(String simplePageMasterMarginLeft)
    {
        this.simplePageMasterMarginLeft = simplePageMasterMarginLeft;
    }

    public String getSimplePageMasterMarginBottom()
    {
        return simplePageMasterMarginBottom;
    }

    public void setSimplePageMasterMarginBottom(String simplePageMasterMarginBottom)
    {
        this.simplePageMasterMarginBottom = simplePageMasterMarginBottom;
    }

    public String getSimplePageMasterMarginTop()
    {
        return simplePageMasterMarginTop;
    }

    public void setSimplePageMasterMarginTop(String simplePageMasterMarginTop)
    {
        this.simplePageMasterMarginTop = simplePageMasterMarginTop;
    }

    public String getSimplePageMasterPageWidth()
    {
        return simplePageMasterPageWidth;
    }

    public void setSimplePageMasterPageWidth(String simplePageMasterPageWidth)
    {
        this.simplePageMasterPageWidth = simplePageMasterPageWidth;
    }

    public String getSimplePageMasterPageHeight()
    {
        return simplePageMasterPageHeight;
    }

    public void setSimplePageMasterPageHeight(String simplePageMasterPageHeight)
    {
        this.simplePageMasterPageHeight = simplePageMasterPageHeight;
    }

    public String getSimplePageMasterRegionBeforeExtent()
    {
        return simplePageMasterRegionBeforeExtent;
    }

    public void setSimplePageMasterRegionBeforeExtent(String simplePageMasterRegionBeforeExtent)
    {
        this.simplePageMasterRegionBeforeExtent = simplePageMasterRegionBeforeExtent;
    }

    public String getSimplePageMasterRegionAfterExtent()
    {
        return simplePageMasterRegionAfterExtent;
    }

    public void setSimplePageMasterRegionAfterExtent(String simplePageMasterRegionAfterExtent)
    {
        this.simplePageMasterRegionAfterExtent = simplePageMasterRegionAfterExtent;
    }

    public String getSimplePageMasterRegionBodyMarginTop()
    {
        return simplePageMasterRegionBodyMarginTop;
    }

    public void setSimplePageMasterRegionBodyMarginTop(String simplePageMasterRegionBodyMarginTop)
    {
        this.simplePageMasterRegionBodyMarginTop = simplePageMasterRegionBodyMarginTop;
    }

    public String getSimplePageMasterRegionBodyMarginBottom()
    {
        return simplePageMasterRegionBodyMarginBottom;
    }

    public void setSimplePageMasterRegionBodyMarginBottom(String simplePageMasterRegionBodyMarginBottom)
    {
        this.simplePageMasterRegionBodyMarginBottom = simplePageMasterRegionBodyMarginBottom;
    }

    public String getTableCellPadding()
    {
        return tableCellPadding;
    }

    public void setTableCellPadding(String tableCellPadding)
    {
        this.tableCellPadding = tableCellPadding;
    }

    public String getTableCellBorder()
    {
        return tableCellBorder;
    }

    public void setTableCellBorder(String tableCellBorder)
    {
        this.tableCellBorder = tableCellBorder;
    }

    public String getTableCellFontSize()
    {
        return tableCellFontSize;
    }

    public void setTableCellFontSize(String tableCellFontSize)
    {
        this.tableCellFontSize = tableCellFontSize;
    }

    public String getTableCellColor()
    {
        return tableCellColor;
    }

    public void setTableCellColor(String tableCellColor)
    {
        this.tableCellColor = tableCellColor;
    }

    public String getTableCellBorderColor()
    {
        return tableCellBorderColor;
    }

    public void setTableCellBorderColor(String tableCellBorderColor)
    {
        this.tableCellBorderColor = tableCellBorderColor;
    }

    public DisplayAlignType getTableCellDisplayAlign()
    {
        return tableCellDisplayAlign;
    }

    public void setTableCellDisplayAlign(DisplayAlignType tableCellDisplayAlign)
    {
        this.tableCellDisplayAlign = tableCellDisplayAlign;
    }

    public String getBlockFontSize()
    {
        return blockFontSize;
    }

    public void setBlockFontSize(String blockFontSize)
    {
        this.blockFontSize = blockFontSize;
    }

    public TextAlignType getBlockTextAlign()
    {
        return blockTextAlign;
    }

    public void setBlockTextAlign(TextAlignType blockTextAlign)
    {
        this.blockTextAlign = blockTextAlign;
    }

    public String getBlockColor()
    {
        return blockColor;
    }

    public void setBlockColor(String blockColor)
    {
        this.blockColor = blockColor;
    }       
}