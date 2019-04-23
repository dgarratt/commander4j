package com.commander4j.Connector.Outbound;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.IOUtils;
import com.commander4j.Interface.Outbound.OutboundInterface;
import com.commander4j.sys.Common;
import com.commander4j.util.JXMLDocument;
import com.commander4j.util.Utility;

import ABSTRACT.com.commander4j.Connector.OutboundConnectorABSTRACT;

public class OutboundConnectorRAW extends OutboundConnectorABSTRACT
{

	Logger logger = org.apache.logging.log4j.LogManager.getLogger((OutboundConnectorRAW.class));

	public OutboundConnectorRAW(OutboundInterface inter)
	{
		super(Connector_XML, inter);
	}

	@Override
	public boolean connectorSave(String path,String filename)
	{
		boolean result = false;
		String fullPath = path+File.separator+filename;

		logger.debug("connectorSave [" + fullPath + "." + getOutboundInterface().getOutputFileExtension().toLowerCase() + "]");
	

		//parsePattern(getOutboundInterface().getOutputPattern());

		JXMLDocument document = new JXMLDocument();
		document.setDocument(getData());

		String byteArray64String = Utility.replaceNullStringwithBlank(document.findXPath("//data/content").trim());
		byte[] returnedBytes = Base64.decodeBase64(byteArray64String);

		FileOutputStream output;
		try
		{
			output = new FileOutputStream(new File(fullPath));
			IOUtils.write(returnedBytes, output);
			result=true;
			
			output.close();
			returnedBytes=null;
			byteArray64String=null;
			output=null;

		} catch (Exception e)
		{
			logger.error("connectorLoad " + getType() + " " + e.getMessage());
			Common.emailqueue.addToQueue("Error", "Error writing " + getType(), "connectorSave " + getType() + " " + e.getMessage() + "\n\n" + fullPath, "");
		}


		return result;
	}

}
