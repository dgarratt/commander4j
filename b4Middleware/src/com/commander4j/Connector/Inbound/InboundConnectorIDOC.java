package com.commander4j.Connector.Inbound;

import com.commander4j.Interface.Inbound.InboundInterface;

public class InboundConnectorIDOC  extends InboundConnectorABSTRACT {
	
	
	public InboundConnectorIDOC(InboundInterface inter)
	{
		super(Connector_IDOC,inter);
	}

	
	@Override
	public boolean connectorLoad(String fullFilename)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}