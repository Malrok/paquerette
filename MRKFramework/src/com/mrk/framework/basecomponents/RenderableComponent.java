package com.mrk.framework.basecomponents;

import com.mrk.entitysystem.interfaces.Component;

public class RenderableComponent implements Component {

	private static final long serialVersionUID = 5738374106504241320L;

	public boolean isRenderable = false;
	
	public RenderableComponent(boolean isRenderable) {
		this.isRenderable = isRenderable;
	}
}
