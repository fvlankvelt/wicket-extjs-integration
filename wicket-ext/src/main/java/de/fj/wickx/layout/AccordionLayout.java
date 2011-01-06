package de.fj.wickx.layout;

import de.fj.wickx.ExtComponent;
import de.fj.wickx.ExtPanel;
import de.fj.wickx.util.ExtProperty;

public class AccordionLayout extends FitLayout {

	@ExtProperty
	protected Boolean animate;

	public AccordionLayout() {
		super(LayoutType.ACCORDION);
	}

	@Override
	public void applyLayout(ExtComponent component) {
		boolean isFirst = true;
		for (ExtComponent item : component.getItems()) {
			if (item instanceof ExtPanel) {
				ExtPanel panel = (ExtPanel) item;
				if (animate != null && animate == false) {
					panel.setAnimCollapse(false);
				}
				panel.setCollapsible(true);
				panel.setAutoWidth(true);
				panel.setTitleCollapse(true);
				panel.setCollapseFirst(false);
				panel.setCollapsed(!isFirst);
			}
			isFirst = false;
		}

		super.applyLayout(component);
	}

	public void setAnimate(Boolean animate) {
		this.animate = animate;
	}

}
