package com.commander4j.Connector.Outbound;

import com.commander4j.Interface.Outbound.OutboundInterface;

public class OutboundConnectorIDOC  extends OutboundConnectorABSTRACT {
	
	public OutboundConnectorIDOC(OutboundInterface inter)
	{
		super(Connector_IDOC,inter);
	}

	@Override
	public boolean connectorSave(String fullFilename)
	{
		boolean result = false;
		
		return result;
	}

}
