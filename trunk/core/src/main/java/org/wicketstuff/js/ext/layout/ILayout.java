package org.wicketstuff.js.ext.layout;

import java.io.Serializable;

import org.wicketstuff.js.ext.ExtComponent;

public interface ILayout extends Serializable {

	void applyLayout(ExtComponent component);

    LayoutType getType();
}
