<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:for-each select="ReportType/MetricDataType">
			<table width="100%" align="center" cellpadding="0" cellspacing="0"
				border="1" style="font-family:verdana;font-size:10pt;border:1">
				<tr>
					<td width="10%" align="left">
						<xsl:value-of select="metric_name" />
					</td>
					<td width="70%" align="left">
						<xsl:value-of select="timestamp" />
					</td>
					<td width="20%" align="left">
						<xsl:value-of select="value" />
					</td>
				</tr>
			</table>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>