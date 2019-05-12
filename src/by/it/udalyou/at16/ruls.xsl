<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

    <xsl:template match="/sites">
        <table border="1">
            <tr><td>Uri</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/sites/site/pages/page">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/sites/site/pages/page/uri">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>